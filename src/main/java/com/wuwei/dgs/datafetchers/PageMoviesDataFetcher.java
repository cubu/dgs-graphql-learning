package com.wuwei.dgs.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

import java.lang.String;

import com.wuwei.dgs.constants.DgsConstants;
import com.wuwei.dgs.service.MovieService;
import com.wuwei.dgs.types.*;
import graphql.schema.DataFetchingEnvironment;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class PageMoviesDataFetcher {

    private final List<MovieEdge> edges = MovieService.movieList().stream().map(
            movie -> MovieEdge.newBuilder()
                    .node(movie)
                    .cursor(Base64.getEncoder().encodeToString(movie.getId().getBytes(StandardCharsets.UTF_8)))
                    .build()
    ).collect(Collectors.toList());


    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.PageMoviesWithCursor)
    public MoviesConnection pageMovies(@InputArgument("first") Integer first,
                                       @InputArgument("after") String after) {

        if (StringUtils.isEmpty(after)) {
          return getConnection(edges.subList(0, first), first);
        }

        boolean found = false;
        int index = 0;
        List<MovieEdge> list = new ArrayList<>();

        for(int i = 0; i < edges.size(); i++) {
          if (!found && !edges.get(i).getCursor().equals(after)) {
            continue;
          }
          if (!found) {
            found = true;
            index = i;
            continue;
          }
          list.add(edges.get(i));
        }
        return getConnection(list, index+1);
    }

    private MoviesConnection getConnection(List<MovieEdge> edges, int first) {
      return MoviesConnection.newBuilder()
              .totalCount(edges.size())
              .edges(edges)
              .pageInfo(
                      PageInfo.newBuilder()
                              .hasPreviousPage(false)
                              .hasNextPage(first < edges.size())
                              .startCursor(edges.get(0).getCursor())
                              .endCursor(edges.get(edges.size() - 1).getCursor())
                              .build()
              )
              .build();
    }

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.PageMovies)
    public PageList pageMovies(@InputArgument("pageSize") Integer pageSize,
                               @InputArgument("pageNum") Integer pageNum) {

        int start = (pageNum-1) * pageSize;
        int end = start + pageSize;
        List<Movie> movies = MovieService.movieList().subList(start, end);
        List<Node> nodes = new ArrayList<>(movies);

        return PageList.newBuilder()
                .totalCount(MovieService.movieList().size())
                .nodes(nodes)
                .build();
    }
}
