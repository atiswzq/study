package com.example.demo1215.DesignDemo.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author kywzq
 * @ClassName Student.java
 * @Description TODO
 * @createTime 2023年12月20日 11:27:00
 */
@Data
@AllArgsConstructor
@ToString
public class Student  {

    private String name;

    private int age;
}
