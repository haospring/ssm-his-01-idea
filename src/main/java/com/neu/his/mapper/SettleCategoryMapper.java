package com.neu.his.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 14727
 * HIS基础信息管理 - 结算类别
 */
public interface SettleCategoryMapper extends BaseMapper {
    /**
     * 根据查询条件，记录数量
     *
     * @param keywords 查询关键字
     * @return int 记录的行数
     */
    int getSettleCategoryCount(@Param("keywords") String keywords);

    /**
     * 查询结算类别所有记录的方法（关键字查询）
     *
     * @param page     当前页
     * @param count    每页显示的记录数量
     * @param keywords 查询关键字
     * @return 包含记录信息的map集合
     */
    List<Map<String, Object>> getSettleCateList(@Param("page") Integer page, @Param("count") Integer count, @Param("keywords") String keywords);

    /**
     * 删除结算类别（更新删除标记）
     *
     * @param ids String类型的数组
     * @return boolean 删除成功==true，删除失败==false
     */
    boolean deleteSettleCategory(@Param("ids") String[] ids);

    /**
     * 删除结算类别（删除数据源）
     *
     * @param ids String类型的数组
     * @return boolean 删除成功==true，删除失败==false
     */
    boolean deleteSettleCategory02(@Param("ids") String[] ids);

    /**
     * 更新结算类型
     *
     * @param map 包含更新类别信息的对象
     * @return int 更新成功==1，更新失败==0
     */
    int updateSettleCategory(Map<String, Object> map);

    /**
     * 添加结算类别
     *
     * @param map 包含添加类别信息的map对象
     * @return int 添加成功==1，添加失败==0
     */
    int addSettleCategory(Map<String, Object> map);
}
