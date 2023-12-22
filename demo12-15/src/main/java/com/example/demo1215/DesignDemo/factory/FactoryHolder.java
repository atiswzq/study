package com.example.demo1215.DesignDemo.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author kywzq
 * @ClassName FactoryHolder.java
 * @Description TODO
 * @createTime 2023年12月22日 09:35:00
 */
@Component
public class FactoryHolder {


   /* public Phone createPhone(){
        return HuaWeiPhoneImpl.builder().cpuCount(1).memoryStorage(123).build();
    }*/


    @Autowired
    private Map<String, Phone> phoneMap;


    public Phone getPhone(String phoneType) {
        Phone bean1 = phoneMap.get(phoneType);
        System.out.println(bean1);
        return bean1;

    }
    /**
     * 总结 工厂模式使用场景：创建对象
     */

}
