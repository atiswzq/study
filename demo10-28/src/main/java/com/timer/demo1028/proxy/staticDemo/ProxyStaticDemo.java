package com.timer.demo1028.proxy.staticDemo;

import com.timer.demo1028.proxy.dynamicDemo.CalculatorImpl;

/**
 * @Description: 静态代理原理
 * @author: wang zeq
 * @date:2021/11/3/003 9:07
 */
public class ProxyStaticDemo {
    // 1.代理原理是让代理类和目标类一起实现接口，然后在代理类中的方法中增加增强代码
    public static void main(String[] args) {
        CalculatorProxy calculatorProxy = new CalculatorProxy(new CalculatorImpl());

        calculatorProxy.add(1, 2);
        calculatorProxy.subtract(1, 2);
    }
}
