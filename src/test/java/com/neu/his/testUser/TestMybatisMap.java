package com.neu.his.testUser;

import com.neu.his.service.UserService;
import com.neu.his.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 14727
 * mybatis 输入参数为Map类型时，如何完成赋值
 */
public class TestMybatisMap {
    private ApplicationContext context;
    private UserService userService;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
        userService = context.getBean("userServiceImpl", UserServiceImpl.class);
    }

    @Test
    public void testAddUser() {
        Map<String, Object> map = new HashMap<>();
        // map中的key必须为实体类中的属性名，必须与映射文件中接收参数值的变量名称一致
        // value记录具体要赋的值
        map.put("userName", "mybatis");
        map.put("password", "mybatis");
        map.put("realName", "mybatis的map类型");
        map.put("deptID", 1);
        userService.addUser(map);
    }
}
