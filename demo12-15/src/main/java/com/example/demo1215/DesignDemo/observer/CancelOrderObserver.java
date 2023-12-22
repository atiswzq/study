package com.example.demo1215.DesignDemo.observer;

/**
 * @author kywzq
 * @ClassName CancelOrderObserver.java
 * @Description 观察者接口
 * @createTime 2023年12月15日 10:21:00
 */
/**
 * 抽象观察者：业务
 */
public interface CancelOrderObserver {
    /**
     * 业务收到订单取消数据后的操作
     */
    void process(CancelOrderBO cancelOrderBO);
}