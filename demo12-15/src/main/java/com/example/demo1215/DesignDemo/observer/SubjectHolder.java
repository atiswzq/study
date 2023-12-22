package com.example.demo1215.DesignDemo.observer;

/**
 * @author kywzq
 * @ClassName SubjectHolder.java
 * @Description 具体执行者
 * @createTime 2023年12月15日 10:27:00
 */
public class SubjectHolder {



    /*自定义支持者写法*/
   /* private static final CancelOrderSubject instance = init();

    private SubjectHolder() {
    }

    // 创建被观察者
    private static CancelOrderSubject init() {

        CancelOrderSubject orderCancelSubject = new CancelOrderSubject();

        // 创建观察者
        CancelOrderObserver accountCancelOrderObserver =
                new AccountCancelOrderObserverImpl();
        CancelOrderObserver storageCancelOrderObserver =
                new StorageCancelOrderObserverImpl();

        // 添加观察者
        orderCancelSubject.addObserver(accountCancelOrderObserver);
        orderCancelSubject.addObserver(storageCancelOrderObserver);
        return orderCancelSubject;
    }

    public static void process(CancelOrderBO cancelOrderBO) {
        instance.process(cancelOrderBO);
    }*/


    /*jdk写法
    * 被观察者继承Observable类
    * 观察者实现Observer接口
    *
    * */
   private static final CancelOrderSubject instance = init();
    private SubjectHolder() {
    }

    // 创建被观察者
    private static CancelOrderSubject init() {

        CancelOrderSubject orderCancelSubject = new CancelOrderSubject();

        // 添加观察者
        orderCancelSubject.addObserver(new AccountCancelOrderObserverImpl());
        orderCancelSubject.addObserver(new StorageCancelOrderObserverImpl());
        return orderCancelSubject;

    }

    public static void process(CancelOrderBO cancelOrderBO) {
        instance.process(cancelOrderBO);
    }



    /*
    * 总结：观察者模式适用于一个业务触发多个相关业务的场景
    * 观察者模式设计步骤：
    *   1.定义被观察者（业务触发者），被观察者里需要定义添加观察者的方法以及触发后执行观察者业务的方法
    *   2.定义观察者（业务执行者） 实现一个业务执行的抽象接口，各自实现具体的业务方法
    *   3.定义主持人（类似代理人去发起业务），初始化加载一个被观察者对象，该对象要实现把所有相关的观察者加入到自己观察者集合中，实现一个总的触发方法，里面调用被观察的的业务触发方法
    *   4.业务触发通过主持人的方法去通知所有相关观察人执行各自的业务逻辑
    * */
}
