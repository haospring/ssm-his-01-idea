package com.neu.his.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 14727
 * Department服务层接口封装
 */
public interface DepartmentService {
    /**
     * 根据输入模糊条件完成科室信息的查询（预留分页参数）
     *
     * @param page     当前页
     * @param count    每页显示的行数
     * @param keywords 查询关键字
     * @return 包含查询结果的map集合
     */
    List<Map<String, Object>> getDepartmentList(@Param("page") Integer page, @Param("count") Integer count, @Param("keywords") String keywords);

    /**
     * 根据输入的模糊查询条件，返回页数的最大行数（页数=最大行数/每页行数）
     *
     * @param keywords 查询关键字
     * @return 纪录最大行数
     */
    int getDepartmentCount(@Param("keywords") String keywords);

    /**
     * 删除科室数据
     *
     * @param ids 字符串类型的数组（支持批量删除和单一删除）
     * @return boolean 删除成功==true，删除时便==false
     */
    boolean deleteDepartmentByIds(@Param("ids") String[] ids);

    /**
     * 更新科室数据
     *
     * @param departmentMap 包含科室信息的map对象
     * @return int 更新成功==1，更新失败==0
     */
    int updateDepartment(Map<String, Object> departmentMap);

    /**
     * 添加科室信息
     *
     * @param departmentMap 包含科室信息的map对象
     * @return int 添加成功==1，添加失败==0
     */
    int addDepartment(Map<String, Object> departmentMap);
}
