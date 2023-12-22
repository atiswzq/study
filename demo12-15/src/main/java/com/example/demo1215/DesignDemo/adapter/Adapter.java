package com.example.demo1215.DesignDemo.adapter;

/**
 * @author kywzq
 * @ClassName Adapter.java
 * @Description TODO
 * @createTime 2023年12月21日 17:01:00
 */
class Adapter implements Param{

    private Param param;

    public Adapter(Param param) {
        this.param = param;
    }

    @Override
    public void doingThings() {
        param.doingThings();
    }
}

