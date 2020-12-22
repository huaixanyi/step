package com.huaxianyi.caffeinecache.controller;

import com.huaxianyi.caffeinecache.domain.CacheEntity;
import com.huaxianyi.caffeinecache.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-16 15:14
 */
@RestController
public class CacheController {

    @Autowired
    private QueryService queryService;

    @GetMapping("/query")
    public ResponseEntity<?> query(Long id) {
        CacheEntity result = queryService.query(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/update")
    public ResponseEntity<?> update(Long id) {
        CacheEntity update = queryService.update(id);
        return ResponseEntity.ok(update);
    }

    @GetMapping("/create")
    public ResponseEntity<?> create(CacheEntity entity) {
        CacheEntity cacheEntity = queryService.create(entity);
        return ResponseEntity.ok(cacheEntity);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> delete(Long id) {
        CacheEntity delete = queryService.delete(id);
        return ResponseEntity.ok(delete);
    }

    @Autowired
    @SuppressWarnings("all")
    private RedisCacheManager redisCacheManager;

    @Autowired
    @SuppressWarnings("all")
    private CaffeineCacheManager caffeineCacheManager;

    @GetMapping("/caches")
    public ResponseEntity<?> getCache() {
        Map<String, Object> map = new HashMap<>();
        Collection<String> cacheNames = redisCacheManager.getCacheNames();
        for (String cacheName : cacheNames) {
            RedisCache cache = (RedisCache) redisCacheManager.getCache(cacheName);
            Cache.ValueWrapper valueWrapper;
            if (cache != null && (valueWrapper = cache.get(cache.getName())) != null) {
                map.put(cache.getName(), valueWrapper.get());
            }
        }
        return ResponseEntity.ok(map);
    }

    @GetMapping("/cachesY")
    public ResponseEntity<?> getCaches() {
        Map<String, ConcurrentMap> cacheMap = caffeineCacheManager.getCacheNames().stream()
                .collect(Collectors.toMap(Function.identity(), name -> {
                    com.github.benmanes.caffeine.cache.Cache cache = (com.github.benmanes.caffeine.cache.Cache) caffeineCacheManager.getCache(name).getNativeCache();
                    return cache.asMap();
                }));
        return ResponseEntity.ok(cacheMap);
    }

}
