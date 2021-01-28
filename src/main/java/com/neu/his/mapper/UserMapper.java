package com.neu.his.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neu.his.pojo.User;

/**
 * @author 14727
 * @description 继承了BaseMapper，并继承了对用户表的操作方法封装
 */
@Mapper
public interface UserMapper extends BaseMapper {
    /**
     * 按照条件进行用户信息查询，并将查询的信息进行分页显示
     *
     * @param page     当前页
     * @param count    count每页显示的记录数
     * @param keywords 查询关键字
     * @return 返回User对象集合
     */
    List<User> getUserList(@Param("page") int page, @Param("count") int count,
                           @Param("keywords") String keywords);

    /**
     * 按照条件进行用户信息查询，并将查询的信息进行分页显示
     *
     * @param page     当前页
     * @param count    count每页显示的记录数
     * @param keywords 查询关键字
     * @return 数据库字段映射到的map的list集合
     */
    List<Map<String, Object>> getUserListMap(@Param("page") int page, @Param("count") int count,
                                             @Param("keywords") String keywords);

    /**
     * 按照条件进行用户信息查询，并将查询的信息进行分页显示（排班规则的医生查询方法）
     *
     * @param page      当前页
     * @param count     每页显示的记录数
     * @param keywords  所在科室
     * @param keywords2 挂号级别
     * @param keywords3 用户名
     * @return 查询到的用户的list集合
     */
    List<User> getUserList02(@Param("page") Integer page, @Param("count") Integer count,
                             @Param("keywords") String keywords, @Param("keywords2") String keywords2,
                             @Param("keywords3") String keywords3);

    /**
     * 根据条件统计记录数量（确定页数最大值时候使用），对应的是getUserList方法
     *
     * @param keywords 查询关键字
     * @return 查询到的结果数
     */
    int getUserCount(@Param("keywords") String keywords);

    /**
     * 根据条件统计记录数量（确定页数最大值时候使用），对应的是getUserList02方法
     *
     * @param keywords  所在科室
     * @param keywords2 挂号级别
     * @param keywords3 用户名
     * @return 查询到的用户个数
     */
    int getUserCount02(@Param("keywords") String keywords, @Param("keywords2") String keywords2,
                       @Param("keywords3") String keywords3);

    /**
     * 根据用户选择的id进行删除操作，对应getUserList方法，参数也可以定义为字符串型数组
     *
     * @param ids 多个用户id
     * @return 删除的个数
     */
    int deleteUserByIds(@Param("ids") int[] ids);

    /**
     * 根据用户id更新用户的删除标志，然后交由管理员删除用户，对应getUserList02方法，
     *
     * @param ids 多个用户id
     * @return 成功更新删除标志的个数
     */
    int deleteUserByIds02(@Param("ids") int[] ids);

    /**
     * 添加用户信息
     *
     * @param user
     * @return 添加成功-->1，添加失败-->0
     */
    int addUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return 更新成功-->1，更新失败-->0
     */
    int updateUserById(User user);

    /**
     * 用户的登录方法
     *
     * @param user 包含用户信息的User对象
     * @return 登陆成功-->1，登录失败-->0
     */
    int login(User user);

    /**
     * 根据用户名密码登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登陆成功-->1，登录失败-->0
     */
    int login02(@Param("username") String username, @Param("password") String password);

    /**
     * 获取user对象
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User getUserBean(@Param("username") String username, @Param("password") String password);
}
