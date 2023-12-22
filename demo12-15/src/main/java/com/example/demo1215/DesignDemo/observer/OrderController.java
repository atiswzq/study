package com.example.demo1215.DesignDemo.observer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kywzq
 * @ClassName OrderController.java
 * @Description TODO
 * @createTime 2023年12月15日 10:30:00
 */
@Api(tags = "订单")
@RestController
@RequestMapping("order")
public class OrderController {
    @ApiOperation("取消订单")
    @PostMapping("cancel")
    public String cancel(@RequestBody CancelOrderBO cancelOrderBO) {
        SubjectHolder.process(cancelOrderBO);
        return "success";
    }
}