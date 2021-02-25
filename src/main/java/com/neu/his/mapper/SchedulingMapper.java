package com.neu.his.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 14727
 * HIS基础信息维护 - 排班管理mapper接口
 */
public interface SchedulingMapper {
    /**
     * 统计排班的记录数量，确定分页的最大行数
     *
     * @param keywords  查询关键字
     * @param keywords2 查询关键字
     * @return 记录满足查询条件的查询到的行数
     */
    int getSchedulingCount(@Param("keywords") String keywords, @Param("keywords2") String keywords2);

    /**
     * 统计排班的记录数量，确定分页的最大行数
     *
     * @param keywords 查询关键字
     * @return 记录满足查询条件的查询到的行数
     */
    int getSchedulingCount02(@Param("keywords") String keywords);

    /**
     * 获取排班医生的挂号额度
     *
     * @param keywords  查询关键字
     * @param keywords2 查询关键字
     * @param keywords3 查询关键字
     * @return int 返回挂号额度的整型数据
     */
    int getSchedulingCount03(@Param("keywords") String keywords, @Param("keywords") String keywords2, @Param("keywords") String keywords3);

    /**
     * 获取排班医生的挂号费的金额
     *
     * @param keywords  查询关键字
     * @param keywords2 查询关键字
     * @param keywords3 查询关键字
     * @return 挂号金额 float
     */
    float getSchedulingCount07(@Param("keywords") String keywords, @Param("keywords2") String keywords2, @Param("keywords3")
            String keywords3);

    /**
     * 按条件查询排班规则记录数的方法
     *
     * @param startPage 当前页
     * @param count     每页显示的记录数
     * @param keywords  查询关键字
     * @param keywords2 查询关键字
     * @return 包含查询结果的Map集合
     */
    List<Map<String, Object>> getSchedulingList(@Param("startPage") Integer startPage,
                                                @Param("count") Integer count, @Param("keywords") String keywords,
                                                @Param("keywords2") String keywords2);

    /**
     * 根据日期，午别，号别，科室查询医生
     *
     * @param startPage 当前页
     * @param count     每页显示的行数
     * @param keywords  查询关键字
     * @param keywords2 查询关键字
     * @param keywords3 查询关键字
     * @param keywords4 查询关键字
     * @return 包含查询结果的Map集合
     */
    List<Map<String, Object>> getSchedulingList02(@Param("startPage") Integer startPage,
                                                  @Param("count") Integer count, @Param("keywords") String keywords,
                                                  @Param("keywords2") String keywords2, @Param("keywords3") String keywords3,
                                                  @Param("keywords4") String keywords4);

    /**
     * 根据日期和午别查询科室
     *
     * @param startPage 当前页
     * @param count     每页显示的行数
     * @param keywords  查询关键字
     * @param keywords2 查询关键字
     * @return 包含查询结果的Map集合
     */
    List<Map<String, Object>> getSchedulingList03(@Param("startPage") Integer startPage, @Param("count") Integer count, @Param("keywords") String keywords, @Param("keywords2") String keywords2);

    /**
     * 根据日期,午别,科室查询号别
     *
     * @param startPage 当前页
     * @param count     每页显示的行数
     * @param keywords  查询关键字
     * @param keywords2 查询关键字
     * @param keywords3 查询关键字
     * @return 包含查询结果的Map集合
     */
    List<Map<String, Object>> getSchedulingList04(@Param("startPage") Integer startPage, @Param("count") Integer count, @Param("keywords") String keywords, @Param("keywords2") String keywords2, @Param("keywords3") String keywords3);

    /**
     * 根据排班日期（看诊日期）查询午别
     *
     * @param startPage 当前页
     * @param count     每页显示的行数
     * @param keywords  查询关键字
     * @return 包含查询结果的Map集合
     */
    List<Map<String, Object>> getSchedulingList05(@Param("startPage") Integer startPage, @Param("count") Integer count, @Param("keywords") String keywords);

    /**
     * 获取排班医生的挂号级别
     *
     * @param keywords  查询关键字
     * @param keywords2 查询关键字
     * @param keywords3 查询关键字
     * @return 挂号级别的整型数值
     */
    int getSchedulingCount08(@Param("keywords") String keywords, @Param("keywords2") String keywords2, @Param("keywords3") String keywords3);

    /**
     * 获取排班医生的科室id
     *
     * @param keywords  查询关键字
     * @param keywords2 查询关键字
     * @param keywords3 查询关键字
     * @return 科室id的整型数据
     */
    int getSchedulingCount09(@Param("keywords") String keywords, @Param("keywords2") String keywords2, @Param("keywords3") String keywords3);

    /**
     * 根据id完成信息删除（通过更新状态字段DelMark代替删除操作
     *
     * @param ids 可以实现批量操作（字符串数组）
     * @return 操作的记录数，整型数值（已经更新的记录数）
     */
    int deleteSchedulingById(@Param("ids") String[] ids);

    /**
     * 根据日期，用户id，午别进行删除
     *
     * @param schedDate 日期
     * @param userID    用户id
     * @param noon      午别
     * @return 操作记录数，整型数值
     */
    int deleteSchedulingByData(@Param("schedDate") String schedDate, @Param("userID") Integer userID, @Param("noon") String noon);

    /**
     * 更新排班记录
     *
     * @param scheduling 包含更新信息的排班对象（Map）
     * @return 更新成功==1，更新失败==0
     */
    int updateSchedulingById(Map<String, Object> scheduling);

    /**
     * 添加排班记录
     *
     * @param scheduling 包含排班信息的对象（Map）
     * @return 添加成功==1，添加失败==0
     */
    int addScheduling(Map<String, Object> scheduling);
}
