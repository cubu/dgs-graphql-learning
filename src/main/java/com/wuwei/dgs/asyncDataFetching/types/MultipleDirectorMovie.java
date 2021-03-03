package com.wuwei.dgs.asyncDataFetching.types;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.List;

/**
 * 同 {@link Movie} 不同的是，此处一个电影包含多个导演{@link Director}
 *
 * @author haozhiqiang
 */
@Data
@Builder
public class MultipleDirectorMovie {

    private long movieId;
    private String name;
    private String directorId;
    private List<Director> directors;

    @Tolerate
    public MultipleDirectorMovie(){}

}
