package com.example.demo1215.DesignDemo.builder;

import lombok.Builder;
import lombok.ToString;

/**
 * @author kywzq
 * @ClassName Student.java
 * @Description TODO
 * @createTime 2023年12月21日 17:31:00
 */
@Builder
@ToString
public class Student {

    private String name;

    private int age;


    public static void main(String[] args) {
        Student student = Student.builder().name("wzq").build();
        System.out.println(student);
    }


}
