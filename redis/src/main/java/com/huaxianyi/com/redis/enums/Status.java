package com.huaxianyi.com.redis.enums;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-18 14:26
 */
@Getter
public enum Status {
    A;

    @Getter
    public enum ExpireEnum {

        S30(30L, TimeUnit.SECONDS);
        private final Long time;
        private final TimeUnit timeUnit;
        ExpireEnum(Long time, TimeUnit timeUnit) {
            this.time = time;
            this.timeUnit = timeUnit;
        }

    }

}
