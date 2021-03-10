package com.wuwei.dgs.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.wuwei.dgs.constants.DgsConstants;
import com.wuwei.dgs.dataloaders.MultipleDirectorsDataLoader;
import com.wuwei.dgs.types.Director;
import com.wuwei.dgs.types.Movie2;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 通过 movieId 加载多个 Director
 * @author haozhiqiang
 */
@DgsComponent
public class DirectorSDataFetcher {

    /**
     *  DgsDataFetchingEnvironment 类加载 DataLoader
     */
    @DgsData(parentType = DgsConstants.MOVIE2.TYPE_NAME, field = DgsConstants.MOVIE2.Directors)
    public CompletableFuture<List<Director>> directors(DgsDataFetchingEnvironment dfe) {
        DataLoader<String, List<Director>> dataLoader = dfe.getDataLoader(MultipleDirectorsDataLoader.class);
        Movie2 multipleDirectorMovie = dfe.getSource();
        return dataLoader.load(multipleDirectorMovie.getId());
    }
}
