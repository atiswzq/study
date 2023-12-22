package com.example.demo1215.DesignDemo.single;

/**
 * @author kywzq
 * @ClassName Dog.java
 * @Description
 * @createTime 2023年12月15日 09:37:00
 */
public class Dog implements Animal{

    @Override
    public void eat() {
        System.out.println("我吃骨头");
    }

    @Override
    public void sleep() {
        System.out.println("我晚上睡觉");
    }
}
