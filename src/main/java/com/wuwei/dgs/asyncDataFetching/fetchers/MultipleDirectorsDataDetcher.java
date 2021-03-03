package com.wuwei.dgs.asyncDataFetching.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.wuwei.dgs.asyncDataFetching.loaders.MultipleDirectorsDataLoader;
import com.wuwei.dgs.asyncDataFetching.types.Director;
import com.wuwei.dgs.asyncDataFetching.types.MultipleDirectorMovie;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author haozhiqiang
 */
@DgsComponent
public class MultipleDirectorsDataDetcher {

    /**
     *  DgsDataFetchingEnvironment 类加载 DataLoader
     */
    @DgsData(parentType = "MultipleDirectorMovie", field = "directors")
    public CompletableFuture<List<Director>> directors(DgsDataFetchingEnvironment dfe) {
        DataLoader<String, List<Director>> dataLoader = dfe.getDataLoader(MultipleDirectorsDataLoader.class);
        MultipleDirectorMovie multipleDirectorMovie = dfe.getSource();
        return dataLoader.load(multipleDirectorMovie.getDirectorId());
    }
}
