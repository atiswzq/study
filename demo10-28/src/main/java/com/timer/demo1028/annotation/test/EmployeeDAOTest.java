package com.timer.demo1028.annotation.test;

/**
 * 和我们平时使用Junit测试时一样
 *
 * @author qiyu
 */
public class EmployeeDAOTest {
    @MyBefore
    public void init() {
        System.out.println("初始化...");
    }

    @MyAfter
    public void destroy() {
        System.out.println("销毁...");
    }

    @MyTest
    public void testDelete() {
        System.out.println("delete...");
    }

    @MyTest
    public void testSave() {
        System.out.println("save...");
    }


}