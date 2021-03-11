package com.wuwei.dgs.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

import java.lang.String;

import com.wuwei.dgs.constants.DgsConstants;
import com.wuwei.dgs.service.MovieService;
import com.wuwei.dgs.types.*;
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
        int size = edges.size();
        if (StringUtils.isEmpty(after)) {
            first = Math.min(first, size);
            return getConnection(edges.subList(0, first), false, first < edges.size());
        }

        boolean found = false;
        int index = -1;
        List<MovieEdge> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (!found && !edges.get(i).getCursor().equals(after)) {
                continue;
            }
            if (!found) {
                found = true;
                index = i;
                continue;
            }
            if (list.size() == first) {
                break;
            }
            list.add(edges.get(i));
        }
        return getConnection(list, index != -1, index + first + 1 < size);
    }

    private MoviesConnection getConnection(List<MovieEdge> list, boolean hasPrevious, boolean hasNext) {
        return MoviesConnection.newBuilder()
                .totalCount(edges.size())
                .edges(list)
                .pageInfo(
                        PageInfo.newBuilder()
                                .hasPreviousPage(hasPrevious)
                                .hasNextPage(hasNext)
                                .startCursor(edges.get(0).getCursor())
                                .endCursor(edges.get(edges.size() - 1).getCursor())
                                .build()
                )
                .build();
    }

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.PageMovies)
    public PageList pageMovies(@InputArgument("pageSize") Integer pageSize,
                               @InputArgument("pageNum") Integer pageNum) {

        int start = (pageNum - 1) * pageSize;
        int end = Math.min(start + pageSize, MovieService.movieList().size());
        List<Movie> movies = MovieService.movieList().subList(start, end);
        List<Node> nodes = new ArrayList<>(movies);

        return PageList.newBuilder()
                .totalCount(MovieService.movieList().size())
                .nodes(nodes)
                .build();
    }
}
