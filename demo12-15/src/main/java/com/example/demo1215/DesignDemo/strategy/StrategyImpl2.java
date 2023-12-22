package com.example.demo1215.DesignDemo.strategy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author kywzq
 * @ClassName StrategyImpl2.java
 * @Description TODO
 * @createTime 2023年12月15日 16:05:00
 */
@Service(value = "s1")
public class StrategyImpl2 implements Strategy {


    @Override
    public void process() {
        System.out.println("strategy 2");
    }
}
