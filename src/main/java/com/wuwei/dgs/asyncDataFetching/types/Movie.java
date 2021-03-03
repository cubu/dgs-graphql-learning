package com.wuwei.dgs.asyncDataFetching.types;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * 一个电影对应一个导演{@link Director}
 *
 * @author haozhiqiang
 */
@Data
@Builder
public class Movie {

    private long movieId;
    private String name;
    private String directorId;
    private Director director;

    @Tolerate
    public Movie(){}

}
