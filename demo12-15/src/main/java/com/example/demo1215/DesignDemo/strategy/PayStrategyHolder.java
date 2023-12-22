package com.example.demo1215.DesignDemo.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author kywzq
 * @ClassName PayStrategyHolder.java
 * @Description 策略模式代理
 * @createTime 2023年12月15日 15:37:00
 */
@Configuration
public class PayStrategyHolder {


    /*策略模式基本写法，实现原理*/

    private static Map<PayType, Pay> payMap = null;
    static {
        payMap = new HashMap<>();
        payMap.put(PayType.ALIPAY,new AliPayImpl());
        payMap.put(PayType.WXPAY, new WeChatPayImpl());
    }

    public static void pay(PayType payType) {
        for (Map.Entry<PayType, Pay> payEntry : payMap.entrySet()) {
            if (payEntry.getKey().equals(payType)) {
                payEntry.getValue().invokeRemoteInterface();
            }
        }
    }
    /*
    * 总结
    * 1.策略模式就是不用条件执行不同方法时，将条件做成枚举，方法抽象出来，
    * 实现步骤：
    *   1.抽象共同方法
    *   2.创建不同方法的实现类实现具体功能
    *   3.创建一个枚举，将可能出现的条件用枚举列举出来
    *   4.创建一个支持者（代理），用map集合记录不用条件执行对应的方法
    *
    * */






}
