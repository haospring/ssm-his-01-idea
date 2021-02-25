package com.neu.his.controller;

import com.neu.his.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/his/scheduling")
/**
 * @author 14727
 */
public class SchedulingController {
    @Autowired
    SchedulingService schedulingService;

    /**
     * 根据输入的时间段完成排班信息查询
     *
     * @param page      当前页
     * @param count     每页显示的行数
     * @param keywords  查询关键字，记录前端传入的时间段
     * @param keywords2 查询关键字，记录前端传入的时间段
     * @return 包含查询结果的Map集合
     */
    @RequestMapping("/all")
    public Map<String, Object> getSchedulingList(Integer page, Integer count, String keywords, String keywords2) {
        int totalCount = schedulingService.getSchedulingCount(keywords, keywords2);
        List<Map<String, Object>> schedulingList = schedulingService.getSchedulingList(0, 5, keywords, keywords2);
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("schedulingList", schedulingList);
        return map;
    }
}
