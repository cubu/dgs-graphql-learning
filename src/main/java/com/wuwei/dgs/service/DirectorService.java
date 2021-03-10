package com.wuwei.dgs.service;

import com.wuwei.dgs.types.Director;

import java.util.*;

/**
 * 此处当作数据接口使用
 *
 * @author haozhiqiang
 */
public class DirectorService {

    static Map<String, Director> directorMap;

    static {
        directorMap = new HashMap<>();
        directorMap.put("11", new Director("11", "甲导儿"));
        directorMap.put("12", new Director("12", "乙导儿"));
        directorMap.put("13", new Director("13", "丙导儿"));
    }

    public static List<Director> loadDirectors(List<String> keys) {
        List<Director> list = new ArrayList<>();
        keys.forEach(key -> list.add(directorMap.get(key)));
        return list;
    }
}
