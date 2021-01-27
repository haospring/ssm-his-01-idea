package com.neu.his.testUser;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neu.his.pojo.User;
import com.neu.his.service.UserService;
import com.neu.his.service.impl.UserServiceImpl;

public class TestUser {
	private UserService userService;

	@Before
	public void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		userService = context.getBean("userServiceImpl", UserServiceImpl.class);
	}

	@Test
	public void testGetUserList() {
		System.out.println(userService.getUserList(0, 3, "bianque"));
	}

	@Test
	public void testGetUserList02() {
		System.out.println(userService.getUserList02(0, 3, "", "", "bianque"));
	}

	@Test
	public void testDeleteUserByIds() {
		System.out.println(userService.deleteUserByIds(new int[]{18,20}));
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setUserName("xiaowang");
		user.setPassword("wang");
		user.setRealName("小王");
		user.setUseType(4);
		user.setDocTitleID(1);
		user.setIsScheduling("1");
		user.setDeptID(3);
		user.setRegistLeID(1);

		System.out.println(userService.addUser(user));
	}

	@Test
	public void testUpdateUserById() {
		User user = new User();
		user.setId(16);
		user.setUserName("齐天大圣");
		user.setPassword("dasheng");
		user.setRealName("孙悟空");
		user.setDocTitleID(3);
		user.setIsScheduling("否");
		user.setDeptID(3);
		user.setRegistLeID(1);

		userService.updateUserById(user);
	}

	@Test
	public void testLogin() {
		System.out.println(userService.login02("bianque","bianque123"));
	}

	@Test
	public void testGetUserBean(){
		User userBean = userService.getUserBean("bianque", "bianque123");
		System.out.println(userBean);
	}
}
