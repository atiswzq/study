package com.example.demo1215.DesignDemo.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author kywzq
 * @ClassName AccountCancelOrderObserverImpl.java
 * @Description 具体观察者: 账户业务
 * @createTime 2023年12月15日 10:22:00
 */
public class AccountCancelOrderObserverImpl implements Observer {



    /*自定义支持者写法继承CancelOrderObserver接口*/
 /*   @Override
    public void process(CancelOrderBO cancelOrderBO) {
        System.out.println("账户业务开始处理订单取消。接收到的消息：" + cancelOrderBO);
    }*/



    /*jdk观察者写法*/
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("库存业务开始处理订单取消。接收到的消息：" + arg);
    }
}
