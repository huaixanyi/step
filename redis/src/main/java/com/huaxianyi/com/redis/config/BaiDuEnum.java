package com.huaxianyi.com.redis.config;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-18 11:45
 */
public enum BaiDuEnum {

    AAA,BBB,CCC,DDD;

    public String isWE(){
        String b = "";
        switch (this){
            case AAA:{
                b = AAA.name();
                break;
            }
            case BBB:{
                b = BBB.name();
                break;
            }
            case CCC:{
                b = CCC.name();
                break;
            }
            case DDD:{
                b = DDD.name();
                break;
            }
        }
        return b;
    }


}
