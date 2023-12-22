package com.timer.demo1028.jpa;

/**
 * @Description: 用一句话描述内容
 * @author: wang zeq
 * @date:2021/10/28/028 10:59
 */
public class UserDaoTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User("bravo1988", 20);
        userDao.add(user);
    }
}
