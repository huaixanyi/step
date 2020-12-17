package com.huaxianyi.caffeinecache.service;

import com.huaxianyi.caffeinecache.domain.CacheEntity;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-16 15:15
 */
public interface QueryService {

    CacheEntity query(Long id);

    CacheEntity update(Long id);

    CacheEntity delete(Long id);

    CacheEntity create(CacheEntity entity);
}

