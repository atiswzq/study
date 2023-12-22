package com.timer.demo1028.proxy.dynamicDemo;

import com.timer.demo1028.proxy.dynamicDemo.Calculator;

/**
 * @Description: 目标类
 * @author: wang zeq
 * @date:2021/11/3/003 9:11
 */
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    @Override
    public int subtract(int a, int b) {
        int result = a - b;
        return result;
    }
}
