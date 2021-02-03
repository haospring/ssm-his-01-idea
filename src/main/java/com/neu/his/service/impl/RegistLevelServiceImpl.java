package com.neu.his.service.impl;

import com.neu.his.mapper.RegistLevelMapper;
import com.neu.his.service.RegistLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 14727
 */
@Service
@Transactional
public class RegistLevelServiceImpl implements RegistLevelService {
    @Autowired
    private RegistLevelMapper mapper;

    @Override
    public int getRegistLevelCount(String keywords) {
        return mapper.getRegistLevelCount(keywords);
    }

    @Override
    public List<Map<String, Object>> getRegistLevelList(Integer page, Integer count, String keywords) {
        return mapper.getRegistLevelList(page, count, keywords);
    }

    @Override
    public boolean deleteRegistLevel(String[] ids) {
        return mapper.deleteRegistLevel(ids);
    }

    @Override
    public boolean deleteRegistLevel02(String[] ids) {
        return mapper.deleteRegistLevel02(ids);
    }

    @Override
    public int updateRegistLevel(Map<String, Object> registLevelMap) {
        return mapper.updateRegistLevel(registLevelMap);
    }

    @Override
    public int addRegistLevel(Map<String, Object> registLevelMap) {
        return mapper.addRegistLevel(registLevelMap);
    }
}
