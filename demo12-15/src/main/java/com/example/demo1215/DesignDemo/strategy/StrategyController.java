package com.example.demo1215.DesignDemo.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kywzq
 * @ClassName StrategyController.java
 * @Description TODO
 * @createTime 2023年12月15日 16:52:00
 */
@RestController
public class StrategyController {

    @Autowired
    StrategyConfig strategyConfig;

    @GetMapping("/test")
    public String pay(String flag) {
        strategyConfig.process(flag);
        return "test success";
    }

}
