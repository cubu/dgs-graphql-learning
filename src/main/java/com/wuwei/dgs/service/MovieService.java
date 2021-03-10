package com.wuwei.dgs.service;

import com.wuwei.dgs.types.Movie;

import java.util.Arrays;
import java.util.List;

/**
 * @author haozhiqiang
 */
public class MovieService {

    public static List<Movie> movieList() {
        return Arrays.asList(
                Movie.newBuilder().id("1").name("酒神").directorId("11").build(),
                Movie.newBuilder().id("2").name("囧神").directorId("12").build(),
                Movie.newBuilder().id("3").name("睡神").directorId("13").build()
        );
    }
}
