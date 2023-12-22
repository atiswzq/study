package com.example.demo1215.DesignDemo.chain;

/**
 * @author kywzq
 * @ClassName UserPasswordHanler.java
 * @Description TODO
 * @createTime 2023年12月21日 13:34:00
 */
public class UserPasswordHanler extends AbstractLoginHandler {
    @Override
    public String doHandler(LoginDTO loginDTO) throws Exception {
        String password = loginDTO.getPassword();
        //验证逻辑：用户密码
        if(!"123456".equals(password)){
            return "密码不正确";
        }
        // 判断是否还有下个责任链节点，没有的话，说明已经是最后一个节点
        if(next!=null){
            return next.doHandler(loginDTO);
        }
        return "验证均已通过，登录成功";
    }
}
