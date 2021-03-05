package com.wuwei.dgs.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.wuwei.dgs.constants.DgsConstants;
import com.wuwei.dgs.types.Movie;
import com.wuwei.dgs.types.MoviesConnection;
import com.wuwei.dgs.types.MultipleDirectorMovie;
import com.wuwei.dgs.types.PageInfo;

import java.util.Arrays;
import java.util.List;

/**
 * movie fetcher
 *
 * @author haozhiqiang
 */
@DgsComponent
public class MoviesDataFetcher {

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.MoviesWithMultipleDirector)
    public List<MultipleDirectorMovie> moviesWithMultipleDirector() {
        return Arrays.asList(
                new MultipleDirectorMovie("1", "酒神", "11", null),
                new MultipleDirectorMovie("2", "囧神", "12", null),
                new MultipleDirectorMovie("3", "睡神", "13", null)
        );
    }

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.PageMovies)
    public MoviesConnection pageMovies(@InputArgument("first") Integer first,
                                       @InputArgument("after") String after) {
        return  new MoviesConnection(3, null, null);
    }

    @DgsData(parentType = DgsConstants.MOVIESCONNECTION.TYPE_NAME, field = DgsConstants.MOVIESCONNECTION.Movies)
    public List<Movie> movies() {
        return Arrays.asList(
                new Movie("1", "酒神", "11", null),
                new Movie("2", "囧神", "12", null),
                new Movie("3", "睡神", "13", null)
        );
    }

    @DgsData(parentType = "MoviesConnection", field = "pageInfo")
    public PageInfo pageInfo() {
        return new PageInfo("endCursorTest", false);
    }
}
