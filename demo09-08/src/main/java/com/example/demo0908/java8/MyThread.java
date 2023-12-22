package com.example.demo0908.java8;

/**
 * @author kywzq
 * @ClassName MyThread.java
 * @Description TODO
 * @createTime 2022年09月08日 17:13:00
 */
public class MyThread {

    // 成员变量
    private MyRunnable target;

    public MyThread() {
    }

    // 构造方法，接收外部传递的出行策略
    public MyThread(MyRunnable target) {
        this.target = target;
    }

    // MyThread自己的run()，现在基本不用了
    public void run() {
        System.out.println("去12306买了一张票");
        System.out.println("坐火车...");
    }

    // 如果外部传递了出行策略，就会调用该策略里的run()
    public void start() {
        if (target != null) {
            target.run();
        } else {
            this.run();
        }
    }
}