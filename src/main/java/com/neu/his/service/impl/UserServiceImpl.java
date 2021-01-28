package com.neu.his.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neu.his.mapper.UserMapper;
import com.neu.his.pojo.User;
import com.neu.his.service.UserService;

/**
 * 用户管理专属的服务层实现类
 *
 * @author 14727
 */

@Transactional
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int getUserCount(String keywords) {
        return userMapper.getUserCount(keywords);
    }

    @Override
    public int getUserCount02(String keywords, String keywords2, String keywords3) {
        return userMapper.getUserCount02(keywords, keywords2, keywords3);
    }

    @Override
    public List<User> getUserList(Integer page, Integer count, String keywords) {
        return userMapper.getUserList(page, count, keywords);
    }

    @Override
    public List<Map<String, Object>> getUserListMap(Integer page, Integer count, String keywords) {
        return userMapper.getUserListMap(page, count, keywords);
    }

    @Override
    public List<User> getUserList02(Integer page, Integer count, String keywords, String keywords2, String keywords3) {
        return userMapper.getUserList02(page, count, keywords, keywords2, keywords3);
    }

    @Override
    public boolean deleteUserByIds(int[] ids) {
        return ids.length == userMapper.deleteUserByIds(ids);
    }

    @Override
    public boolean deleteUserByIds02(int[] ids) {
        return ids.length == userMapper.deleteUserByIds02(ids);
    }

    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    @Override
    public int login(User user) {
        return userMapper.login(user);
    }

    @Override
    public int login02(String username, String password) {
        return userMapper.login02(username, password);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User getUserBean(String username, String password) {
        return userMapper.getUserBean(username, password);
    }
}
