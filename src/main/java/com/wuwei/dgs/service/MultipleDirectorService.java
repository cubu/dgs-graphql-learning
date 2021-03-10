package com.wuwei.dgs.service;

import com.wuwei.dgs.types.Director;

import java.util.*;

/**
 * @author haozhiqiang
 */
public class MultipleDirectorService {

    static Map<String, List<Director>> directorMap;

    static {
        directorMap = new HashMap<>();
        directorMap.put("1", Arrays.asList(
                new Director("111", "甲A导儿"),
                new Director("112", "甲B导儿")
        ));
        directorMap.put("2", Arrays.asList(
                new Director("121", "乙A导儿"),
                new Director("122", "乙B导儿")
        ));
        directorMap.put("3", Arrays.asList(
                new Director("131", "丙A导儿"),
                new Director("132", "丙B导儿")
        ));
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
