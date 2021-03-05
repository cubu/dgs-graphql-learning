package com.wuwei.dgs.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.wuwei.dgs.constants.DgsConstants;
import com.wuwei.dgs.dataloaders.MultipleDirectorsDataLoader;
import com.wuwei.dgs.types.Director;
import com.wuwei.dgs.types.MultipleDirectorMovie;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author haozhiqiang
 */
@DgsComponent
public class MultipleDirectorsDataFetcher {

    /**
     *  DgsDataFetchingEnvironment 类加载 DataLoader
     */
    @DgsData(parentType = DgsConstants.MULTIPLEDIRECTORMOVIE.TYPE_NAME, field = DgsConstants.MULTIPLEDIRECTORMOVIE.Directors)
    public CompletableFuture<List<Director>> directors(DgsDataFetchingEnvironment dfe) {
        DataLoader<String, List<Director>> dataLoader = dfe.getDataLoader(MultipleDirectorsDataLoader.class);
        MultipleDirectorMovie multipleDirectorMovie = dfe.getSource();
        return dataLoader.load(multipleDirectorMovie.getDirectorId());
    }
}
