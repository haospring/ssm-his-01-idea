package com.neu.his.service.impl;

import com.neu.his.mapper.DepartmentMapper;
import com.neu.his.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 14727
 * Department表的服务接口的实现
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper mapper;

    @Override
    public List<Map<String, Object>> getDepartmentList(Integer page, Integer count, String keywords) {
        return mapper.getDepartmentList(page, count, keywords);
    }

    @Override
    public int getDepartmentCount(String keywords) {
        return mapper.getDepartmentCount(keywords);
    }

    @Override
    public boolean deleteDepartmentByIds(String[] ids) {
        return mapper.deleteDepartmentByIds(ids);
    }

    @Override
    public int updateDepartment(Map<String, Object> departmentMap) {
        return mapper.updateDepartment(departmentMap);
    }

    @Override
    public int addDepartment(Map<String, Object> departmentMap) {
        return mapper.addDepartment(departmentMap);
    }
}
