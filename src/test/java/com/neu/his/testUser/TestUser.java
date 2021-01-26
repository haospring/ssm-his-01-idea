package com.neu.his.testUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neu.his.pojo.User;
import com.neu.his.service.UserService;
import com.neu.his.service.impl.UserServiceImpl;

public class TestUser {
	private ApplicationContext context;
	private UserService userService;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("spring-dao.xml");
		userService = context.getBean("userServiceImpl", UserServiceImpl.class);
	}

	@Test
	public void testGetUserList() {
		List<Map<String, Object>> userList = userService.getUserList(1, 5, "a");
		for (Map<String, Object> map : userList) {
			Set<Entry<String, Object>> entrySet = map.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				String key = entry.getKey();
				Object user = entry.getValue();
				System.out.println(key + "---" + user);
			}
		}
	}

	@Test
	public void testGetUserList02() {
		List<Map<String, Object>> userList = userService.getUserList02(1, 5, "", "", "a");
		System.out.println(userList);
	}

	@Test
	public void testDeleteUserByIds() {
		userService.deleteUserByIds(new int[] {10});
	}

	@Test
	public void testAddUser() {
		Map<String ,Object> map = new HashMap<>();
		User user = new User();
		user.setUserName("xiaowang");
		user.setPassword("wang");
		user.setRealName("小王");
		user.setUseType(4);
		user.setDocTitleID(1);
		user.setIsScheduling("1");
		user.setDeptID(3);
		user.setRegistLeID(1);

		map.put("userName",user.getUserName());
		map.put("password",user.getPassword());
		map.put("realName",user.getRealName());
		map.put("useType",user.getUseType());
		map.put("docTitleID",user.getDocTitleID());
		map.put("isScheduling",user.getIsScheduling());
		map.put("deptID",user.getDeptID());
		map.put("registLeID",user.getRegistLeID());

		int addUser = userService.addUser(map);
		System.out.println(addUser);
	}

	@Test
	public void testAddUser02() {
		User user = new User();
		user.setUserName("三");
		user.setPassword("san");
		user.setRealName("张三");
		user.setUseType(4);
		user.setDocTitleID(1);
		user.setIsScheduling("1");
		user.setDeptID(3);
		user.setRegistLeID(1);
		user.setDelMark(1);

		int addUser02 = userService.addUser02(user);
		System.out.println(addUser02);
	}

	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setId(17);
		user.setUserName("xiaoli");
		user.setPassword("xiaoli");
		user.setRealName("小李");
		user.setDocTitleID(3);
		user.setIsScheduling("否");
		user.setDeptID(3);
		user.setRegistLeID(1);

		userService.updateUserById(user);
	}

	@Test
	public void testUpdateUserById() {
		User user = new User();
		user.setId(14);
		user.setUserName("四");
		user.setPassword("si");
		user.setRealName("李四");
		user.setDocTitleID(1);
		user.setIsScheduling("是");
		user.setDeptID(3);
		user.setRegistLeID(1);

		userService.updateUserById(user);
	}

	@Test
	public void testLogin() {
		Map<String,Object> map = new HashMap<>();
		map.put("userName","bianque");
		map.put("password","bianque123");
		System.out.println(userService.login(map));
	}

	@Test
	public void testLogin02() {
		int login02 = userService.login02("bianque", "bianque123");
		System.out.println(login02);
	}

	@Test
	public void testgetUserBean(){
		User userBean = userService.getUserBean("bianque", "bianque123");
		System.out.println(userBean);
	}
}
