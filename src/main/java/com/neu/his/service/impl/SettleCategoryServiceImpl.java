package com.neu.his.service.impl;

import com.neu.his.mapper.SettleCategoryMapper;
import com.neu.his.service.SettleCategoryService;
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
public class SettleCategoryServiceImpl implements SettleCategoryService {
    @Autowired
    private SettleCategoryMapper mapper;

    @Override
    public int getSettleCategoryCount(String keywords) {
        return mapper.getSettleCategoryCount(keywords);
    }

    @Override
    public List<Map<String, Object>> getSettleCateList(Integer page, Integer count, String keywords) {
        return mapper.getSettleCateList(page, count, keywords);
    }

    @Override
    public boolean deleteSettleCategory(String[] ids) {
        return mapper.deleteSettleCategory(ids);
    }

    @Override
    public boolean deleteSettleCategory02(String[] ids) {
        return mapper.deleteSettleCategory02(ids);
    }

    @Override
    public int updateSettleCategory(Map<String, Object> map) {
        return mapper.updateSettleCategory(map);
    }

    @Override
    public int addSettleCategory(Map<String, Object> map) {
        return mapper.addSettleCategory(map);
    }
}
