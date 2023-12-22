package com.example.demo1215.DesignDemo.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author kywzq
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2023年12月15日 14:39:00
 */
@Service
public class UserService implements ApplicationEventPublisherAware {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String username) {
        // 执行注册逻辑
        logger.info("[register][执行用户({}) 的注册逻辑]", username);
        // 发布
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this, username));
    }


    /*
    * 总结：
    * springboot观察者模式可以用于数据监听的场景，实现步骤
    * 1.定义事件监听项，监听项继承ApplicationEvent类
    * 2.定义一个消息发送代理类，实现ApplicationEventPublisherAware方法，生成一个消息发送对象，执行publishEvent方法发送对应的监听项
    * 3.接听者（观察者）通过注解@EventListener在对应方法上实现监听后业务逻辑
    *
    * 可以用来解耦合
    *
    * */

}
