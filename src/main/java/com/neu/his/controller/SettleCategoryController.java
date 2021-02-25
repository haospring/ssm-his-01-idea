package com.neu.his.controller;

import com.neu.his.pojo.RespBean;
import com.neu.his.service.SettleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Context;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 14727
 */
@RestController
@CrossOrigin
@RequestMapping("/his/settleCategory")
public class SettleCategoryController {
    @Autowired
    private SettleCategoryService service;


    @RequestMapping("/query")
    public Map<String, Object> getSettleCateList(Integer page, Integer count, String keywords) {
        int maxCount = service.getSettleCategoryCount(keywords);

        page = page == null ? 0 : page;
        count = count == null ? maxCount : count;

        if (page > (maxCount / count) || page <= 0) {
            page = 0;
        } else {
            page = (page - 1) * count;
        }
        List<Map<String, Object>> settleCateList = service.getSettleCateList(page, count, keywords);
        Map<String, Object> map = new HashMap<>();
        map.put("maxCount", maxCount);
        map.put("settleCateList", settleCateList);

        return map;
    }

    @RequestMapping("/add")
    public RespBean addSettleCategory(@RequestParam Map<String, Object> map) {

        if (service.addSettleCategory(map) == 1) {
            return new RespBean("success", "添加成功");
        }
        return new RespBean("error", "添加失败");
    }

    @RequestMapping("/update")
    public RespBean updateSettleCategory(@RequestParam Map<String, Object> map) {
        if (service.updateSettleCategory(map) == 1) {
            return new RespBean("success", "更新成功");
        }
        return new RespBean("error", "更新失败");
    }

    @RequestMapping("/delete")
    public RespBean deleteSettleCategory(String ids) {
        String[] id = ids.split(",");
        if (service.deleteSettleCategory(id)) {
            return new RespBean("success", "删除成功（更新删除标记）");
        }
        return new RespBean("error", "删除失败（更新删除标记）");
    }

    @RequestMapping("/delete02")
    public RespBean deleteSettleCategory02(String ids) {
        String[] id = ids.split(",");
        if (service.deleteSettleCategory02(id)) {
            return new RespBean("success", "删除成功（删除数据源）");
        }
        return new RespBean("error", "删除失败（删除数据源）");
    }
}
