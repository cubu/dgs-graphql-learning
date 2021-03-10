package com.wuwei.dgs.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.wuwei.dgs.constants.DgsConstants;
import com.wuwei.dgs.service.MovieService;
import com.wuwei.dgs.types.Movie;
import java.util.List;

/**
 * movie fetcher
 *
 * @author haozhiqiang
 */
@DgsComponent
public class MoviesDataFetcher {

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.Movies)
    public List<Movie> listMovie() {
        return MovieService.movieList();
    }

}
