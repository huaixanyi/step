package com.huaxianyi.caffeinecache.util;

import com.huaxianyi.caffeinecache.domain.CacheEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-17 14:35
 */
public class CacheMap<T> {

    /*Collections.synchronizedMap();*/
    private static final Map<Long, CacheEntity> cacheMap = new HashMap<>();

    public static CacheEntity setSync(Long key, CacheEntity val) {
        synchronized (cacheMap) {
            cacheMap.put(key, val);
            return val;
        }
    }

    public static Map<Long, CacheEntity> get() {
        return cacheMap;
    }
}
