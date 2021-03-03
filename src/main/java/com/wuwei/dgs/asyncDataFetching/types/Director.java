package com.wuwei.dgs.asyncDataFetching.types;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author haozhiqiang
 */
@Data
@Builder
public class Director {

    private String directorId;
    private String name;

    @Tolerate
    public Director(){}

}
