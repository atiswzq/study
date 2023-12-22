package com.example.demo1215.DesignDemo.observer;

import java.util.*;

/**
 * @author kywzq
 * @ClassName CancelOrderSubject.java
 * @Description 被观察者（订单取消）
 * @createTime 2023年12月15日 10:21:00
 */
public class CancelOrderSubject extends Observable {


    /*jdk被观察者写法*/
    private Vector<Observer> cancelOrderObserverList = new Vector<>();

    public void addObserver(Observer cancelOrderObserver){
        cancelOrderObserverList.add(cancelOrderObserver);
    }
    public void process(CancelOrderBO cancelOrderBO) {
        System.out.println("订单取消的相关数据：" + cancelOrderBO);
        for (Observer cancelOrderObserver : cancelOrderObserverList) {
            cancelOrderObserver.update(new CancelOrderSubject(),cancelOrderBO);
        }
    }

    /*自定义观察者写法*/
    /*List<CancelOrderObserver> cancelOrderObserverList = new ArrayList<>();

    public void addObserver(CancelOrderObserver cancelOrderObserver){
        cancelOrderObserverList.add(cancelOrderObserver);
    }

    public void notifyObservers(CancelOrderObserver cancelOrderObserver){
        cancelOrderObserverList.remove(cancelOrderObserver);
    }

    public void notifyObservers(CancelOrderBO cancelOrderBO) {
        System.out.println("订单取消的相关数据：" + cancelOrderBO);
        for (CancelOrderObserver cancelOrderObserver : cancelOrderObserverList) {
            cancelOrderObserver.process(cancelOrderBO);
        }
    }*/


}
