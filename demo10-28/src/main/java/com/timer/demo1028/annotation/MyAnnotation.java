package com.timer.demo1028.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Description: 用一句话描述内容
 * @author: wang zeq
 * @date:2021/10/28/028 8:38
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String getValue();
}
