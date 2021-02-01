package com.neu.his.testUser;

import com.neu.his.mapper.DepartmentMapper;
import com.neu.his.service.DepartmentService;
import com.neu.his.service.impl.DepartmentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.Context;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDepartment {
    private DepartmentService service;

    @Before
    public void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        service = context.getBean("departmentServiceImpl", DepartmentServiceImpl.class);
    }

    @Test
    public void testGetDepartmentList() {
        List<Map<String, Object>> departmentList = service.getDepartmentList(0, 5, "内科");
        System.out.println(departmentList);
    }

    @Test
    public void testGetDepartmentCount() {
        int count = service.getDepartmentCount("内科");
        System.out.println(count);
    }

    @Test
    public void testAddDepartment() {
        Map<String, Object> departmentMap = new HashMap<>();
        departmentMap.put("DeptCode", "XEK");
        departmentMap.put("DeptName", "小儿科");
        departmentMap.put("DeptCategoryID", 11);
        departmentMap.put("DeptType", 1);
        System.out.println(service.addDepartment(departmentMap));
    }

    @Test
    public void testUpdateDepartment() {
        Map<String, Object> departmentMap = new HashMap<>();
        departmentMap.put("ID", 140);
        departmentMap.put("DeptCode", "EK");
        departmentMap.put("DeptName", "儿科");
        departmentMap.put("DeptCategoryID", 11);
        departmentMap.put("DeptType", 1);
        System.out.println(service.updateDepartment(departmentMap));
    }

    @Test
    public void testDeleteDepartmentByIds() {
        System.out.println(service.deleteDepartmentByIds(new String[]{"140"}));
    }
}
