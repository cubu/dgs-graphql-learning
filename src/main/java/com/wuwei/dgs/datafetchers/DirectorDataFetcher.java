package com.wuwei.dgs.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.wuwei.dgs.constants.DgsConstants;
import com.wuwei.dgs.types.Director;
import com.wuwei.dgs.types.Movie;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * 通过 directorId 加载一个 Director
 * @author haozhiqiang
 */
@DgsComponent
public class DirectorDataFetcher {

    /**
     * DgsDataFetchingEnvironment 通过 DataLoader name 字符串加载 DataLoader
     */
    @DgsData(parentType = DgsConstants.MOVIE.TYPE_NAME, field = DgsConstants.MOVIE.Director)
    public CompletableFuture<Director> director(DataFetchingEnvironment dfe) {
        DataLoader<String, Director> dataLoader = dfe.getDataLoader("directors");
        Movie movie = dfe.getSource();
        return dataLoader.load(movie.getDirectorId());
    }
}