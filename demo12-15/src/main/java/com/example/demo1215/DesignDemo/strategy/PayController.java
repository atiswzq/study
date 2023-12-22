package com.example.demo1215.DesignDemo.strategy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kywzq
 * @ClassName PayController.java
 * @Description TODO
 * @createTime 2023年12月15日 15:38:00
 */
@RestController
public class PayController {
    @GetMapping("/pay")
    public String pay(PayType payType) {
        PayStrategyHolder.pay(payType);
        return "test success";
    }
}