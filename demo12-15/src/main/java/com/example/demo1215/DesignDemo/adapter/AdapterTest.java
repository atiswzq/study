package com.example.demo1215.DesignDemo.adapter;



/**
 * @author kywzq
 * @ClassName AdapterTest.java
 * @Description TODO
 * @createTime 2023年12月21日 17:02:00
 */
public class AdapterTest {

    public static void work(Adapter adapter){
        System.out.println("准备开始干活");
        adapter.doingThings();
        System.out.println("干完活了");
    }

    public static void main(String[] args) {
        Param param1 = new Param1Impl();
        Param param2 = new Param2Impl();
        Adapter adapter1= new Adapter(param1);
        Adapter adapter2= new Adapter(param2);

        work(adapter1);
        work(adapter2);
    }
}
