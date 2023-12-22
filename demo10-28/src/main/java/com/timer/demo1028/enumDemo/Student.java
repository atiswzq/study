package com.timer.demo1028.enumDemo;

import lombok.Data;

/**
 * @Description: 用一句话描述内容
 * @author: wang zeq
 * @date:2021/11/4/004 9:13
 */

@Data
public class Student {

    private String name;

    private Student(String name) {
        this.name = name;
    }
}
