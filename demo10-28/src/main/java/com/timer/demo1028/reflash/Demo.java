package com.timer.demo1028.reflash;

/**
 * @Description: 反射demo
 * @author: wang zeq
 * @date:2021/11/2/002 15:47
 */
public class Demo {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> demo = Class.forName("com.timer.demo1028.reflash.Demo");
        System.out.println(demo);
        demo = Demo.class;
        System.out.println(demo);
        demo = new Demo().getClass();
        System.out.println(demo);
    }
}
