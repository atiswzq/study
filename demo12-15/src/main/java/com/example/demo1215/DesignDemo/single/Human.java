package com.example.demo1215.DesignDemo.single;

/**
 * @author kywzq
 * @ClassName Human.java
 * @Description TODO
 * @createTime 2023年12月15日 09:58:00
 */
public class Human implements Animal, AdvancedAnimal {
    @Override
    public void play() {
        System.out.println("我会打牌");
    }

    @Override
    public void eat() {
        System.out.println("我吃肯德基");
    }

    @Override
    public void sleep() {
        System.out.println("我会随时睡觉");

    }
}
