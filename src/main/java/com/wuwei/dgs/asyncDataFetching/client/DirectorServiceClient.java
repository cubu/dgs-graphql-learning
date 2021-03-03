package com.wuwei.dgs.asyncDataFetching.client;

import com.wuwei.dgs.asyncDataFetching.types.Director;

import java.util.*;

/**
 * 此处当作数据接口使用
 *
 * @author haozhiqiang
 */
public class DirectorServiceClient {

    static Map<String, List<Director>> directorMap;

    static {
        directorMap = new HashMap<>();
        directorMap.put("11", Arrays.asList(
                Director.builder().directorId("11").name("甲A导儿").build(),
                Director.builder().directorId("11").name("甲B导儿").build()
        ));
        directorMap.put("12", Arrays.asList(
                Director.builder().directorId("12").name("乙A导儿").build(),
                Director.builder().directorId("12").name("乙B导儿").build()
        ));
        directorMap.put("13", Arrays.asList(
                Director.builder().directorId("13").name("丙A导儿").build(),
                Director.builder().directorId("13").name("丙B导儿").build()
        ));
    }

    public static List<Director> loadDirectors(List<String> keys) {
        List<Director> list = new ArrayList<>();
        keys.forEach(key -> list.add(directorMap.get(key).get(0)));
        return list;
    }

    public static Map<String, List<Director>> loadMapDirectors(Set<String> keys) {
        Map<String, List<Director>> map = new HashMap<>();
        keys.forEach(key -> {
            if(directorMap.containsKey(key)) {
                map.put(key, directorMap.get(key));
            }
        });
        return map;
    }
}
