package com.example.demo1215.DesignDemo.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kywzq
 * @ClassName PhoneController.java
 * @Description TODO
 * @createTime 2023年12月22日 09:40:00
 */
@RestController
public class PhoneController {

    @Autowired
    private FactoryHolder factoryHolder;

    @GetMapping("/phone")
    public String drawMyShape(@RequestParam  String type) {
        shapeBeanFactoryDraw(type);
        return "成功";
    }

    private void shapeBeanFactoryDraw(String type) {
     /*   System.out.println("======= 实现二 shapeBeanFactory =======");
        FactoryHolder factory = new FactoryHolder();
        Phone shapeInterface1 = factory.createPhone();
        shapeInterface1.callUp();*/
        Phone shapeInterface2 = factoryHolder.getPhone( type);
        shapeInterface2.callUp();
    }
}
