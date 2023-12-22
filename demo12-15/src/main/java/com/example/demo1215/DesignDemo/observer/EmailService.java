package com.example.demo1215.DesignDemo.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author kywzq
 * @ClassName EmailService.java
 * @Description TODO
 * @createTime 2023年12月15日 14:40:00
 */
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent>{

    private Logger logger = LoggerFactory.getLogger(getClass());

    /*异步监听*/

    @Override
    @Async
    public void onApplicationEvent(UserRegisterEvent event) {

        logger.info("线程对象：{}",Thread.currentThread().getName());
        logger.info("[onApplicationEvent][给用户({}) 发送邮件]", event.getUsername());
    }
   /* @EventListener
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("[onApplicationEvent][给用户({}) 发送邮件]"+ event.getUsername());
    }*/

}
