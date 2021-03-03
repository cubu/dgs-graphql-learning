package com.wuwei.dgs.asyncDataFetching.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.wuwei.dgs.asyncDataFetching.types.Director;
import com.wuwei.dgs.asyncDataFetching.types.Movie;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * @author haozhiqiang
 */
@DgsComponent
public class DirectorDataFetcher {

    /**
     * DgsDataFetchingEnvironment 通过 DataLoader name 字符串加载 DataLoader
     */
    @DgsData(parentType = "Movie", field = "director")
    public CompletableFuture<Director> director(DataFetchingEnvironment dfe) {
        DataLoader<String, Director> dataLoader = dfe.getDataLoader("directors");
        Movie movie = dfe.getSource();
        return dataLoader.load(movie.getDirectorId());
    }
}