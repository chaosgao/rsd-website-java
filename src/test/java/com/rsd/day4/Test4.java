package com.rsd.day4;


import com.rsd.bean.Behavior;
import com.rsd.dao.IBehaviorDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test4 {

    @Autowired
    private IBehaviorDAO behavior;

     List<Behavior> aa(Integer id){
         List lists = new ArrayList();
        List<Behavior> list = behavior.getByFatherId(id);

        for (Behavior l : list){
            if (list!= null && list.isEmpty()){
                aa(l.getId());
                lists.add(l.getName()+"\t"+l.getId()+"\t"+l.getFatherId());
            }
        }
        return list;
    }

    @Test
    public void test1(){
        List<Behavior> list = aa(0);
        for (Behavior ll : list){
            System.out.println(ll.getId()+"\t"+ll.getName()+"\t"+ll.getFatherId());
        }
    }

    }
