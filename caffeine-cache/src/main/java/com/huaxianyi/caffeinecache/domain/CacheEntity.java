package com.huaxianyi.caffeinecache.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-17 16:27
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CacheEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

}
