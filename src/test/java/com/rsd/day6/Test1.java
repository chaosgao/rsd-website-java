package com.rsd.day6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.rsd.bean.Behavior;
import com.rsd.dao.IBehaviorDAO;
import com.rsd.service.IBehaviorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test1 {

    @Autowired
    private IBehaviorService behaviorService;

    @Test
    public void test1() throws JsonProcessingException {
        List<Behavior> list = behaviorService.treeList1();

        JsonMapper jsonMapper = new JsonMapper();
        String json = jsonMapper.writeValueAsString(list);
        System.out.println(json);
    }

    @Test
    public void test2() throws JsonProcessingException {
        List<Behavior> list = behaviorService.treeList2();

        JsonMapper jsonMapper = new JsonMapper();
        String json = jsonMapper.writeValueAsString(list);
        System.out.println(json);
    }

    @Autowired
    private IBehaviorDAO behaviorDAO;

    @Test
    public void test3() {
        List<Behavior> list = behaviorDAO.list();
        System.out.println(list);
    }
}

