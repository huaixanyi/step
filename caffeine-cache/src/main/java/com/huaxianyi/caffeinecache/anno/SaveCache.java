package com.huaxianyi.caffeinecache.anno;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.lang.annotation.*;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-17 16:39
 */
@Caching(put = {
        @CachePut(value = "cacheMap", key = "#entity.id"),
        @CachePut(value = "cacheMap", key = "#entity.name"),
},
        cacheable =
        @Cacheable(cacheNames = "cacheMap", unless = "#result == null")
)
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SaveCache {
}
