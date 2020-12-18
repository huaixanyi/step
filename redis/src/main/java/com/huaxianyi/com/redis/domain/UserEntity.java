package com.huaxianyi.com.redis.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-18 14:52
 */
@Setter
@Getter
public class UserEntity implements Serializable {
    private Long id;
    private String guid;
    private String name;
    private String age;
    private Date createTime;
}
