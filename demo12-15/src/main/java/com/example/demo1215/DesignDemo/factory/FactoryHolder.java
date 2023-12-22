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
     * 总结 工厂模式使用场景：创建对象，跟策略模式类似，策略模式创建的是实现方法
     * 实现步骤
     *  1.定义抽象方法
     *  2.创建对应的类实现方法，这些类通过注解@Service注入到spring容器中，可以通过@Value注解指定bean名称
     *  3.创建工厂类，可以通过@Autowired注解注入所有实现抽象方法的bean，用map集合存储，key为指定的bean名称，默认是类名，value为bean
     *  4，通过传入不同的key去获取不同的bean实现创建不同对象
     */

}
