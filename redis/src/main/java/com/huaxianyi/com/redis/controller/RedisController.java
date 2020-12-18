package com.huaxianyi.com.redis.controller;

import com.huaxianyi.com.redis.config.RedisUtil;
import com.huaxianyi.com.redis.domain.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-18 14:51
 */
@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {

    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("set")
    public boolean redisset(String key, String value) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setGuid(String.valueOf(1));
        userEntity.setName("zhangsan");
        userEntity.setAge(String.valueOf(20));
        userEntity.setCreateTime(new Date());

        //return redisUtil.set(key,userEntity,ExpireTime);

        return redisUtil.set(key, userEntity);
    }

    @RequestMapping("get")
    public Object redisget(String key) {
        return redisUtil.get(key);
    }

    @RequestMapping("expire")
    public boolean expire(String key) {
        return redisUtil.expire(key, ExpireTime);
    }
}
