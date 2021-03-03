package com.wuwei.dgs.asyncDataFetching.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.wuwei.dgs.asyncDataFetching.types.Movie;
import com.wuwei.dgs.asyncDataFetching.types.MultipleDirectorMovie;

import java.util.Arrays;
import java.util.List;

/**
 * movie fetcher
 *
 * @author haozhiqiang
 */
@DgsComponent
public class MoviesDataFetcher {

    @DgsData(parentType = "Query", field = "movies")
    public List<Movie> movies() {
        return Arrays.asList(
                Movie.builder().movieId(1).name("酒神").directorId("11").build(),
                Movie.builder().movieId(2).name("囧神").directorId("12").build(),
                Movie.builder().movieId(2).name("睡神").directorId("13").build()
        );
    }

    @DgsData(parentType = "Query", field = "moviesWithMultipleDirector")
    public List<MultipleDirectorMovie> moviesWithMultipleDirector() {
        return Arrays.asList(
                MultipleDirectorMovie.builder().movieId(1).name("酒神").directorId("11").build(),
                MultipleDirectorMovie.builder().movieId(2).name("囧神").directorId("12").build(),
                MultipleDirectorMovie.builder().movieId(2).name("睡神").directorId("13").build()
        );
    }
}
