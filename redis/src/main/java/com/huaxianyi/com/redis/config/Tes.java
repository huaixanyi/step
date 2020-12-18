package com.huaxianyi.com.redis.config;

import com.huaxianyi.com.redis.enums.Status;

import java.util.concurrent.TimeUnit;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-18 11:48
 */
public class Tes {


    public static void main(String[] args) {
        Status.ExpireEnum d = Status.ExpireEnum.S30;

        Long time = d.getTime();
        TimeUnit timeUnit = d.getTimeUnit();
        System.out.println(timeUnit);

    }
}
