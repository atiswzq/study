package com.example.demo1215.DesignDemo.factory;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author kywzq
 * @ClassName XiaoMiPhoneImpl.java
 * @Description TODO
 * @createTime 2023年12月22日 09:33:00
 */
@Data
@Service(value = "xiaomi")
public class XiaoMiPhoneImpl implements Phone {
    /**
     * CPU个数
     */

    private Integer cpuCount;

    /**
     * 内存大小
      */

    private Integer memoryStorage;

   /* public XiaoMiPhoneImpl(Integer cpuCount, Integer memoryStorage) {
        this.cpuCount = cpuCount;
        this.memoryStorage = memoryStorage;
    }*/

    @Override
    public void callUp() {
        System.out.println("小米手机打电话");
    }
}