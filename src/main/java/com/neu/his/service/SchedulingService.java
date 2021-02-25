package com.neu.his.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 14727
 * HIS基础信息 - 排班信息
 */
public interface SchedulingService {
    /**
     * 按条件查询排班规则记录数的方法
     *
     * @param startPage 当前页
     * @param count     每页显示的记录数
     * @param keywords  查询关键字
     * @param keywords2 查询关键字
     * @return 包含查询结果的Map集合
     */
    List<Map<String, Object>> getSchedulingList(Integer startPage, Integer count, String keywords, String keywords2);

    /**
     * 统计排班的记录数量，确定分页的最大行数
     *
     * @param keywords  查询关键字
     * @param keywords2 查询关键字
     * @return 记录满足查询条件的查询到的行数
     */
    int getSchedulingCount(String keywords, String keywords2);
}
