package com.huaxianyi.caffeinecache.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import javax.annotation.Resource;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-18 15:07
 */
@Configuration
public class CacheConfig {

    @Resource
    private RedisConnectionFactory factory;

    @Bean
    public RedisCacheManager redisCacheManager() {
        return RedisCacheManager
                .builder(factory)
                .cacheDefaults(
                        RedisCacheConfiguration
                                .defaultCacheConfig()
                                .disableKeyPrefix()
                                .disableCachingNullValues()
                                .serializeValuesWith(
                                        RedisSerializationContext
                                                .SerializationPair
                                                .fromSerializer(new GenericJackson2JsonRedisSerializer())
                                )
                ).build();
    }

//    @Bean
//    @Primary
//    public RedisCacheManager redisCacheManager() {
//        return new RedisCaffeineCacheManager();
//    }

}
