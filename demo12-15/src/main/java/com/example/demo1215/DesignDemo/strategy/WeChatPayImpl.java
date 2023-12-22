package com.example.demo1215.DesignDemo.strategy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author kywzq
 * @ClassName WeChatPayImpl.java
 * @Description TODO
 * @createTime 2023年12月15日 15:37:00
 */
@Component
public class WeChatPayImpl implements Pay {

    @Override
    public void invokeRemoteInterface() {
        System.out.println("调用远程接口：" + PayType.WXPAY.getDescripe());
    }
}