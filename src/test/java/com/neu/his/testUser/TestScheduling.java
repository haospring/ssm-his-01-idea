package com.neu.his.testUser;

import com.neu.his.service.SchedulingService;
import com.neu.his.service.impl.SchedulingServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class TestScheduling {
    private SchedulingService service;

    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        service = context.getBean("schedulingServiceImpl", SchedulingServiceImpl.class);
    }

    @Test
    public void test() {
        List<Map<String, Object>> list = service.getSchedulingList(0, 5, "2019-04-01", "2019-04-03");
        System.out.println(list);
    }
}
