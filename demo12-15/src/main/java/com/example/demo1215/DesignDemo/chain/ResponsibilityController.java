package com.example.demo1215.DesignDemo.chain;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kywzq
 * @ClassName ResponsibilityController.java
 * @Description TODO
 * @createTime 2023年12月21日 13:34:00
 */
@RestController
@RequestMapping("/responsibility")
public class ResponsibilityController {
    /**
     * 登录测试
     */
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) throws Exception {
        AbstractLoginHandler.Builder<Object> builder = new AbstractLoginHandler.Builder<>();
        String result = builder.addHandler(new UserExistHandler())
                .addHandler(new UserStatusHandler())
                .addHandler(new UserPasswordHanler())
                .build().doHandler(loginDTO);
        return "登录结果："+result;
    }
}

