package com.example.demo1215.DesignDemo.observer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

/**
 * @author kywzq
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2023年12月15日 14:44:00
 */
@Api(tags = "用户")
@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("register")
    public String register(@RequestParam String username) {

        userService.register(username);
        return "success";
    }
}
