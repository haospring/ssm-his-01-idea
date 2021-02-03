package com.neu.his.controller;

import com.neu.his.pojo.RespBean;
import com.neu.his.service.RegistLevelService;
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
 */
@RestController
@CrossOrigin
@RequestMapping("/his/registLevel")
public class RegistLevelController {
    @Autowired
    private RegistLevelService service;

    @RequestMapping("/query")
    public Map<String, Object> getRegistLevelList(Integer page, Integer count, String keywords) {
        int registLevelCount = service.getRegistLevelCount(keywords);
        List<Map<String, Object>> registLevelList = service.getRegistLevelList(0, 10, keywords);

        Map<String, Object> registLevelMap = new HashMap<>();
        registLevelMap.put("registLevelCount", registLevelCount);
        registLevelMap.put("registLevelList", registLevelList);

        return registLevelMap;
    }

    @RequestMapping("/add")
    public RespBean addRegistLevel(@RequestParam Map<String, Object> map) {
        if (service.addRegistLevel(map) == 1) {
            return new RespBean("success", "添加成功（挂号）");
        }
        return new RespBean("error", "添加失败（挂号）");
    }

    @RequestMapping("/update")
    public RespBean updateRegistLevel(@RequestParam Map<String, Object> map) {

        if (service.updateRegistLevel(map) == 1) {
            return new RespBean("success", "更新成功");
        }
        return new RespBean("error", "更新失败");
    }

    @RequestMapping("/delete02")
    public RespBean deleteRegistLevel02(String ids) {
        String[] id = ids.split(",");
        boolean flag = service.deleteRegistLevel02(id);
        if (flag) {
            return new RespBean("success", "删除成功（更新删除标记）");
        }
        return new RespBean("error", "删除失败（更新删除标记）");
    }

    @RequestMapping("/delete")
    public RespBean deleteRegistLevel(String ids) {
        String[] id = ids.split(",");
        boolean flag = service.deleteRegistLevel(id);
        if (flag) {
            return new RespBean("success", "删除成功（删除数据源）");
        }
        return new RespBean("error", "删除失败（删除数据源）");
    }
}
