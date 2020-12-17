package com.huaxianyi.caffeinecache.service.impl;

import com.huaxianyi.caffeinecache.anno.SaveCache;
import com.huaxianyi.caffeinecache.domain.CacheEntity;
import com.huaxianyi.caffeinecache.service.QueryService;
import com.huaxianyi.caffeinecache.util.CacheMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-17 14:25
 */
@CacheConfig(cacheNames = {"query-result", "demo", "test"})
@Service
public class QueryServiceImpl implements QueryService {

    private static final Logger LOG = LoggerFactory.getLogger(QueryService.class);
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Cacheable(cacheNames = "cacheMap", key = "'id:'+ #id", condition = "#id != null", unless = "#result == null")
    @Override
    public CacheEntity query(Long id) {
        LOG.info("keyWord:{}", id);
        return CacheMap.get().get(id);
    }

    @CachePut(cacheNames = "cacheMap", key = "'id:'+ #id")
    @Override
    public CacheEntity update(Long id) {
        return CacheMap.setSync(id, new CacheEntity(id, format.format(new Date())));
    }

    @CacheEvict(cacheNames = "cacheMap", key = "'id:'+ #id")
    @Override
    public CacheEntity delete(Long id) {
        return CacheMap.get().remove(id);
    }

    @SaveCache
    @Override
    public CacheEntity create(CacheEntity entity) {
        return CacheMap.setSync(entity.getId(), entity);
    }
}
