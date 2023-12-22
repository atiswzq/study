package com.example.demo1215.DesignDemo.strategy;

/**
 * @author kywzq
 * @ClassName PayType.java
 * @Description TODO
 * @createTime 2023年12月15日 15:32:00
 */
public enum PayType {

    ALIPAY("支付宝支付"),
    WXPAY("微信支付")
    ;

    private String descripe;

    PayType(String descripe) {
        this.descripe = descripe;
    }


    public String getDescripe() {
        return descripe;
    }

}
