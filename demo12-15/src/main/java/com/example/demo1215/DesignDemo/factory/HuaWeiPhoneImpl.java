package com.example.demo1215.DesignDemo.factory;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author kywzq
 * @ClassName HuaWeiPhoneImpl.java
 * @Description TODO
 * @createTime 2023年12月22日 09:34:00
 */
@Data
@Service(value = "huawei")
public class HuaWeiPhoneImpl implements Phone {
    /**
     * CPU个数
     */
    private Integer cpuCount;

    /**
     * 内存大小
     */
    private Integer memoryStorage;
/*
    public HuaWeiPhoneImpl(Integer cpuCount, Integer memoryStorage) {
        this.cpuCount = cpuCount;
        this.memoryStorage = memoryStorage;
    }*/

    @Override
    public void callUp() {
        System.out.println("华为手机打电话");
    }
}