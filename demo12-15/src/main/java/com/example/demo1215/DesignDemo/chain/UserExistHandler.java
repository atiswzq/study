package com.example.demo1215.DesignDemo.chain;

/**
 * @author kywzq
 * @ClassName UserExistHandler.java
 * @Description TODO
 * @createTime 2023年12月21日 13:32:00
 */
public class UserExistHandler extends AbstractLoginHandler {

    @Override
    public String doHandler(LoginDTO loginDTO) throws Exception {
        String username = loginDTO.getUsername();
        //验证逻辑：如果用户不存在
        if(!"test_user".equals(username)){
            return "用户不存在";
        }
        // 判断是否还有下个责任链节点，没有的话，说明已经是最后一个节点
        if (next != null){
            return next.doHandler(loginDTO);
        }
        return "验证均已通过，登录成功";
    }
}
