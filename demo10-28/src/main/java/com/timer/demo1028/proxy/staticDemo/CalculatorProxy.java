package com.timer.demo1028.proxy.staticDemo;

import com.timer.demo1028.proxy.dynamicDemo.Calculator;

/**
 * @Description: 代理类
 * @author: wang zeq
 * @date:2021/11/3/003 9:13
 */
public class CalculatorProxy implements Calculator {

    // 引入接口
    private Calculator calculator;

    // 生成代理类的构造函数
    public CalculatorProxy(Calculator calculator) {
        this.calculator = calculator;
    }


    @Override
    public int add(int a, int b) {
        System.out.println("add方法开始...");
        int result = calculator.add(a, b);
        System.out.println("add方法开始...");
        return result;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("add方法开始...");
        int result = calculator.add(a, b);
        System.out.println("add方法开始...");
        return result;
    }
}
