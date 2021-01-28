package com.neu.his.controller;

import javax.servlet.http.HttpServletRequest;

import com.neu.his.pojo.RespBean;
import com.neu.his.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neu.his.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 14727
 * RestController 该注解可以让方法支持json格式
 * RequestMapping 给控制类定义访问地址（满足restful风格）
 * CrossOrigin 代表该控制类下的所有请求都可以跨域访问
 * origin="*"表示所有地址都可以访问，maxAge表示最大时效，单位是秒
 */
@RestController
@RequestMapping("/his/user")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {
    /**
     * 声明成员属性userService，完成自动注入
     */
    @Autowired
    private UserService userService;

    /**
     * @param request  请求对象可以获取参数值
     * @param keywords 接受用户的查询条件
     * @return 返回对象的List集合
     */
    @RequestMapping("/all")
    public List<User> getUserList(HttpServletRequest request, String keywords) {
        // 声明counts用来接受数据库中所有的查询到的行数
        int counts = userService.getUserCount(keywords);
        List<User> userList = userService.getUserList(0, counts, keywords);
        return userList;
    }

    /**
     * @param request   请求对象
     * @param keywords  部门编号
     * @param keywords2 挂号级别
     * @param keywords3 用户名
     * @return 返回对象的List集合
     */
    @RequestMapping("/all02")
    public List<User> getUserList02(HttpServletRequest request, String keywords, String keywords2, String keywords3) {
        int counts = userService.getUserCount02(keywords, keywords2, keywords3);
        List<User> userList = userService.getUserList02(0, counts, keywords, keywords2, keywords3);
        return userList;
    }

    /**
     * @param request 如果用户选择批量删除，可以通过该对象获取数组
     * @param id      接受用户选择的单条数据对应的id
     * @return RespBean 该实体封装了响应信息（成功||失败）
     */
    @RequestMapping("/deleteByIds")
    public RespBean deleteUserByIds(HttpServletRequest request, Integer id) {
        boolean flag = userService.deleteUserByIds(new int[]{id});
        if (flag) {
            return new RespBean("success", "删除成功");
        } else {
            return new RespBean("error", "删除失败");
        }
    }

    /**
     * @param request 用来封装页面的请求对象
     * @param user    封装页面的用户信息
     * @return 返回响应信息
     */
    @RequestMapping("/add")
    public RespBean addUser(HttpServletRequest request, User user) {
        user = new User();
        user.setUserName("天蓬元帅");
        user.setPassword("tianpeng");
        user.setRealName("猪八戒");
        user.setDocTitleID(3);
        user.setIsScheduling("是");
        user.setDeptID(3);
        user.setRegistLeID(1);

        int flag = userService.addUser(user);
        if (flag == 1) {
            return new RespBean("success", "添加成功");
        } else {
            return new RespBean("error", "添加失败");
        }
    }

    /**
     * @param request 封装请求对象
     * @param user    页面中需要修改的用户信息
     * @return 更新的结果反馈
     */
    @RequestMapping("/update")
    public RespBean updateUserById(HttpServletRequest request, User user) {
        user = new User();
        user.setId(24);
        user.setUserName("天蓬元帅");
        user.setPassword("laozhu");
        user.setRealName("猪八戒");
        user.setDocTitleID(3);
        user.setIsScheduling("是");
        user.setDeptID(3);
        user.setRegistLeID(1);
        int flag = userService.updateUserById(user);
        if (flag == 1) {
            return new RespBean("success", "更新成功");
        } else {
            return new RespBean("error", "更新失败");
        }
    }

    /**
     * @param request  请求对象
     * @param username 用户名
     * @param password 密码
     * @return 登录反馈
     */
    @RequestMapping("login")
    public RespBean login(HttpServletRequest request, String username, String password) {
        System.out.println(username);
        System.out.println(password);
        User user = userService.getUserBean(username, password);
        if (user != null) {
            request.getSession().setAttribute("login_user",user);
            // 记录状态的整型值，状态的标识值，信息，对象
            return new RespBean(0, "success", "登陆成功", user);
        } else {
            return new RespBean(1,"error", "登录失败");
        }
    }
}
