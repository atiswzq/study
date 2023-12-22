package com.example.demo1215.DesignDemo.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author kywzq
 * @ClassName StrategyConfig.java
 * @Description TODO
 * @createTime 2023年12月15日 16:19:00
 */
@Configuration
public class StrategyConfig {


    @Autowired
    Map<String, Strategy> strategyMap;

    void process(String flag){
        strategyMap.get(flag).process();
    }


    /*
    * 总结：策略模式
    * 1.定义一个策略接口，创建实现接口的具体工具类，这些类需要用@service注解注入到spring中,value指定bean的名称
    * 2.创建一个主持人（代理）,需要用@configuration注解，确保服务启动从spring中获取对应bean
    * 4.通过传不同的key（条件）去调取对应的策略方法实现策略模式
    *
    * 使用场景：多条件需要执行不同方法时
    * */
}
