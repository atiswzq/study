package com.example.demo1215.DesignDemo.observer;

import org.springframework.context.ApplicationEvent;

/**
 * @author kywzq
 * @ClassName UserRegisterEvent.java
 * @Description 用户注册事件
 * @createTime 2023年12月15日 14:38:00
 */
public class UserRegisterEvent extends ApplicationEvent {
    /**
     * 用户名
     */
    private String username;

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
