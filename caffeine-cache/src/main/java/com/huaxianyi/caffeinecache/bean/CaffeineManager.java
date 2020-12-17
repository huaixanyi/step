package com.huaxianyi.caffeinecache.bean;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-17 17:50
 */
@Configuration
@EnableCaching
public class CaffeineManager {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(
                Caffeine.newBuilder().
                        expireAfterAccess(20000, TimeUnit.MILLISECONDS).
                        maximumSize(5).
                        initialCapacity(5)
        );
        return caffeineCacheManager;
    }

}
