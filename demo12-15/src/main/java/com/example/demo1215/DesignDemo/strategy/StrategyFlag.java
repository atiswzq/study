package com.example.demo1215.DesignDemo.strategy;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author kywzq
 * @ClassName StrategyFlag.java
 * @Description TODO
 * @createTime 2023年12月15日 16:57:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public  @interface StrategyFlag {
    String value();
}
