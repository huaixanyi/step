package com.huaxianyi.caffeinecache.controller;

import com.github.benmanes.caffeine.cache.Cache;
import com.huaxianyi.caffeinecache.domain.CacheEntity;
import com.huaxianyi.caffeinecache.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private CacheManager cacheManager;

    @GetMapping("/caches")
    public ResponseEntity<?> getCache() {
        Map<String, ConcurrentMap> cacheMap = cacheManager.getCacheNames().stream()
                .collect(Collectors.toMap(Function.identity(), name -> {
                    Cache cache = (Cache) cacheManager.getCache(name).getNativeCache();
                    return cache.asMap();
                }));
        return ResponseEntity.ok(cacheMap);
    }

}
