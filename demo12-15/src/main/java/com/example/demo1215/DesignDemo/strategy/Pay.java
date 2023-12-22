package com.example.demo1215.DesignDemo.strategy;

/**
 * @author kywzq
 * @ClassName Pay.java
 * @Description TODO
 * @createTime 2023年12月15日 15:35:00
 */
public interface Pay {

    /**
     * 调用远程的支付接口
     */
    void invokeRemoteInterface();
}
