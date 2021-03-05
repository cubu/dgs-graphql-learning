package com.wuwei.dgs.service;

import com.wuwei.dgs.types.Director;

import java.util.*;

/**
 * 此处当作数据接口使用
 *
 * @author haozhiqiang
 */
public class DirectorService {

    static Map<String, List<Director>> directorMap;

    static {
        directorMap = new HashMap<>();
        directorMap.put("11", Arrays.asList(
                new Director("11", "甲A导儿"),
                new Director("11", "甲B导儿")
        ));
        directorMap.put("12", Arrays.asList(
                new Director("12", "乙A导儿"),
                new Director("112", "乙B导儿")
        ));
        directorMap.put("13", Arrays.asList(
                new Director("13", "丙A导儿"),
                new Director("13", "丙B导儿")
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
