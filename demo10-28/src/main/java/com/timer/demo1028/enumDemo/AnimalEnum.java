package com.timer.demo1028.enumDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * @Description: 用一句话描述内容
 * @author: wang zeq
 * @date:2021/11/4/004 10:53
 */
@Getter
@ToString
@AllArgsConstructor
public enum AnimalEnum {

    CAT(1, "小花"),
    DOG(2, "小花"),
    MOUSE(3, "小花");

    private Integer age;
    private String name;

    public static AnimalEnum getByCode(String code) {
        for (AnimalEnum animalEnum : AnimalEnum.values()) {
            if (animalEnum.getName().equals(code)) {
                return animalEnum;
            }
        }
        return null;
    }
}
