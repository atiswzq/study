package com.example.demo1215.DesignDemo.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author kywzq
 * @ClassName CouponService.java
 * @Description TODO
 * @createTime 2023年12月15日 14:41:00
 */
@Service
public class CouponService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @EventListener
    public void addCoupon(UserRegisterEvent event) {
        logger.info("线程对象：{}",Thread.currentThread().getName());
        logger.info("[addCoupon][给用户({}) 发放优惠劵]",event.getUsername());
    }
}
