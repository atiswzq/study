package com.example.demo1215.DesignDemo.single;

/**
 * @author kywzq
 * @ClassName Cat.java
 * @Description TODO
 * @createTime 2023年12月15日 09:37:00
 */
public class Cat implements Animal{

    @Override
    public void eat() {
        System.out.println("我吃鱼");
    }

    @Override
    public void sleep() {
        System.out.println("我白天睡觉");
    }
}
