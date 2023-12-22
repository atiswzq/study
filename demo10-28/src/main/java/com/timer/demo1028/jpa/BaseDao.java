package com.timer.demo1028.jpa;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

/**
 * @Description: 用一句话描述内容
 * @author: wang zeq
 * @date:2021/10/28/028 10:55
 */
public class BaseDao<T> {

    private static BasicDataSource datasource;

    static {
        datasource = new BasicDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/timer");
        datasource.setUsername("root");
        datasource.setPassword("123456");

    }

    // 得到jdbcTemplate
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
    // DAO操作的对象
    private Class<T> beanClass;

    /**
     * 构造器
     * 初始化时完成对实际类型参数的获取，比如BaseDao<User>插入User，那么beanClass就是user.class
     */
    public BaseDao() {
        beanClass = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }


    public void add(T bean) {
        // 得到User对象的所有字段
        Field[] declaredFields = beanClass.getDeclaredFields();

        // 拼接sql语句，表名直接用POJO的类名，所以创建表时，请注意写成User，而不是t_user
        StringBuilder sql = new StringBuilder()
                .append("insert into ")
                .append(beanClass.getSimpleName())
                .append(" values(");
        for (int i = 0; i < declaredFields.length; i++) {
            sql.append("?");
            if (i < declaredFields.length - 1) {
                sql.append(",");
            }
        }
        sql.append(")");

        // 获得bean字段的值（要插入的记录）
        ArrayList<Object> paramList = new ArrayList<>();
        try {
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                Object o = declaredField.get(bean);
                paramList.add(o);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        int size = paramList.size();
        Object[] params = paramList.toArray(new Object[size]);

        // 传入sql语句模板和模板所需的参数，插入User
        int num = jdbcTemplate.update(sql.toString(), params);
        System.out.println(num);
    }

}
