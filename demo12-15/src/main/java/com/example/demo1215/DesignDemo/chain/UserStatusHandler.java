package com.example.demo1215.DesignDemo.chain;

/**
 * @author kywzq
 * @ClassName UserStatusHandler.java
 * @Description TODO
 * @createTime 2023年12月21日 13:34:00
 */
public class UserStatusHandler extends AbstractLoginHandler {

    @Override
    public String doHandler(LoginDTO loginDTO) throws Exception {
        String status = loginDTO.getStatus();
        //验证逻辑：如果用户已被冻结
        if("freeze".equals(status)){
            return "账户已被冻结";
        }
        // 判断是否还有下个责任链节点，没有的话，说明已经是最后一个节点
        if(next!=null){
            return next.doHandler(loginDTO);
        }
        return "验证均已通过，登录成功";
    }
}
