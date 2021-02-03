package com.neu.his.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 14727
 * HIS基础信息维护-挂号级别接口定义
 */
@Mapper
public interface RegistLevelMapper {
    /**
     * 根据输入的模糊条件完成行数查询
     *
     * @param keywords 查询的关键字
     * @return 返回查询的行数
     */
    int getRegistLevelCount(@Param("keywords") String keywords);

    /**
     * 按照输入的条件查询挂号记录
     *
     * @param page     当前页
     * @param count    每页显示的记录数
     * @param keywords 查询关键字
     * @return 包含查询结果的map对象
     */
    List<Map<String, Object>> getRegistLevelList(@Param("page") Integer page, @Param("count") Integer count, @Param("keywords") String keywords);

    /**
     * 删除挂号记录的方法
     *
     * @param ids 字符串类型的id数组
     * @return 删除成功==true，删除失败==false
     */
    boolean deleteRegistLevel(@Param("ids") String[] ids);

    /**
     * 更新挂号表的删除标记
     *
     * @param ids 字符串类型的id数组
     * @return 更新成功==true，更新失败==false
     */
    boolean deleteRegistLevel02(@Param("ids") String[] ids);

    /**
     * 更新挂号记录的方法
     *
     * @param registLevelMap 包含挂号信息的map集合
     * @return 更新成功==1，更新失败==0
     */
    int updateRegistLevel(Map<String, Object> registLevelMap);

    /**
     * 添加挂号信息的方法
     *
     * @param registLevelMap 包含添加挂号信息的对象
     * @return 添加成功==1，添加失败==0
     */
    int addRegistLevel(Map<String, Object> registLevelMap);
}
