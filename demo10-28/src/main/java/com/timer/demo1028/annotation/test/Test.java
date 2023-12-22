package com.timer.demo1028.annotation.test;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 用一句话描述内容
 * @author: wang zeq
 * @date:2021/10/28/028 10:37
 */
public class Test {
    public static void main(String[] args) {

        ArrayList<Chinese> chineseArrayList = new ArrayList<>();
        chineseArrayList.add(new Chinese("李健"));
        chineseArrayList.add(new Chinese("周深"));

        ArrayList<Japanese> japaneseArrayList = new ArrayList<>();
        japaneseArrayList.add(new Japanese("三浦春马"));
        japaneseArrayList.add(new Japanese("瑛太"));

        /**
         * 与编译器约定，左右两边类型不一致也能赋值，但是有条件：
         * 右边List的参数类型必须是Human的子类
         */
        List<? extends Human> humanList = chineseArrayList;
        Human lee = humanList.get(0);
        Human chou = humanList.get(1);
        System.out.println(lee + "&" + chou);

        humanList = japaneseArrayList;
        Human haRuMa = humanList.get(0);
        Human eiTa = humanList.get(1);
        System.out.println(haRuMa + "&" + eiTa);

    }

    @AllArgsConstructor
    static class Human {
        private String name;
    }

    public static class Chinese extends Human {
        public Chinese(String name) {
            super(name);
        }
    }

    public static class Japanese extends Human {
        public Japanese(String name) {
            super(name);
        }
    }


}
