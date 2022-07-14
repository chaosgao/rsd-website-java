package com.rsd.day6;

import com.rsd.bean.NewsType;
import com.rsd.dao.INewsTypeDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test4 {

    @Autowired
    private INewsTypeDAO newsTypeDAO;

    @Test
    public void test1(){
        List<NewsType> list = newsTypeDAO.queryList();
        System.out.println(list);
    }
}
