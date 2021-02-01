package com.neu.his.controller;

import com.neu.his.pojo.RespBean;
import com.neu.his.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 14727
 * 完成控制类的封装
 */
@RestController
@RequestMapping("/his/department")
@CrossOrigin(origins = "*")
public class DepartmentController {
    /**
     * DepartmentService自动注入，注入的是DepartmentServiceImpl
     */
    @Autowired
    DepartmentService service;

    /**
     * @param page     当前页
     * @param count    每页显示的记录数量
     * @param keywords 查询条件
     * @return 查询到的数据条数和部门信息的map对象
     */
    @RequestMapping("/all")
    public Map<String, Object> getDepartmentList(Integer page, Integer count, String keywords) {
        int maxCount = service.getDepartmentCount(keywords);
        List<Map<String, Object>> departmentListMap = service.getDepartmentList(129, 10, keywords);

        Map<String, Object> departmentMap = new HashMap<>();
        departmentMap.put("maxCount", maxCount);
        departmentMap.put("departmentListMap", departmentListMap);

        return departmentMap;
    }

    /**
     * 添加科室信息
     *
     * @param departmentMap 包含的科室信息
     * @return 封装响应信息
     */
    @RequestMapping("/add")
    public RespBean addDepartment(@RequestParam Map<String, Object> departmentMap) {
        int result = service.addDepartment(departmentMap);
        if (result == 1) {
            return new RespBean("success", "添加成功（科室）");
        }
        return new RespBean("error", "添加失败（科室）");
    }

    /**
     * 更新科室信息
     *
     * @param departmentMap 包含的科室信息
     * @return 封装响应信息
     */
    @RequestMapping("/update")
    public RespBean updateDepartment(@RequestParam Map<String, Object> departmentMap) {

        int result = service.updateDepartment(departmentMap);
        if (result == 1) {
            return new RespBean("success", "更新成功（科室）");
        }
        return new RespBean("error", "更新失败（科室）");
    }

    /**
     * 根据id完成科室信息的删除（既可以单个删除，也可以批量删除）
     *
     * @param id 包含了id信息的字符串
     * @return 响应信息的封装
     */
    @RequestMapping("/delete")
    public RespBean deleteDepartmentByIds(String id) {
        String[] ids = id.split(",");
        boolean flag = service.deleteDepartmentByIds(ids);
        if (flag) {
            return new RespBean("success", "删除成功（科室）");
        }
        return new RespBean("error", "删除失败（科室）");
    }

}
