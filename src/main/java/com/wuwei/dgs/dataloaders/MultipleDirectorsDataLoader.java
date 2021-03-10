package com.wuwei.dgs.dataloaders;

import com.netflix.graphql.dgs.DgsDataLoader;
import com.wuwei.dgs.service.DirectorService;
import com.wuwei.dgs.service.MultipleDirectorService;
import com.wuwei.dgs.types.Director;
import org.dataloader.MappedBatchLoader;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * 当一个key对应多个value时，implement MappedBatchLoader<K,V> 接口，
 * 加载过程中 multipleDirectors 的数据结构为 Map<K,V>
 *
 * @author haozhiqiang
 */
@DgsDataLoader(name = "multipleDirectors", caching = true, batching = true, maxBatchSize = 100)
public class MultipleDirectorsDataLoader implements MappedBatchLoader<String, List<Director>> {
    @Override
    public CompletionStage<Map<String, List<Director>>> load(Set<String> keys) {
        return CompletableFuture.supplyAsync(
                () -> MultipleDirectorService.loadMapDirectors(keys)
        );
    }
}
