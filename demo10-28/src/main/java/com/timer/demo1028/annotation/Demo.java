package com.timer.demo1028.annotation;

import java.lang.annotation.Annotation;
import java.sql.SQLOutput;

/**
 * @Description: 用一句话描述内容
 * @author: wang zeq
 * @date:2021/10/28/028 8:39
 */
@MyAnnotation(getValue = "annotation on class")
public class Demo {

    @MyAnnotation(getValue = "annotation on field")
    public String name;

    @MyAnnotation(getValue = "annotation on method")
    public void hello() {
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        // 获取类上的注解
        Class<Demo> clazz = Demo.class;
        MyAnnotation annotationOnClass = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnClass.getValue());

        // 获取属性的注解
        Class<Demo> clazz2 = Demo.class;
        MyAnnotation annotationOnClass2 = clazz2.getField("name").getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnClass2.getValue());

        // 获取方法的注解
        Class<Demo> clazz3 = Demo.class;
        MyAnnotation annotationOnClass3 = clazz3.getMethod("hello").getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnClass3.getValue());

    }


}