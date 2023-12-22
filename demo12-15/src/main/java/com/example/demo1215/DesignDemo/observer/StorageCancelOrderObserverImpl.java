package com.example.demo1215.DesignDemo.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author kywzq
 * @ClassName StorageCancelOrderObserverImpl.java
 * @Description 具体观察者: 库存业务
 * @createTime 2023年12月15日 10:23:00
 */
public class StorageCancelOrderObserverImpl implements Observer {
   /* @Override
    public void process(CancelOrderBO cancelOrderBO) {
        System.out.println("库存业务开始处理订单取消。接收到的消息：" + cancelOrderBO);
    }*/

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("库存业务开始处理订单取消。接收到的消息：" + arg);
    }
}