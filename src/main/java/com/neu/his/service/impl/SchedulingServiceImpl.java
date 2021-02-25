package com.neu.his.service.impl;

import com.neu.his.mapper.SchedulingMapper;
import com.neu.his.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SchedulingServiceImpl implements SchedulingService {
    @Autowired
    private SchedulingMapper mapper;

    @Override
    public List<Map<String, Object>> getSchedulingList(Integer startPage, Integer count, String keywords, String keywords2) {
        return mapper.getSchedulingList(startPage, count, keywords, keywords2);
    }

    @Override
    public int getSchedulingCount(String keywords, String keywords2) {
        return mapper.getSchedulingCount(keywords, keywords2);
    }
}
