package com.rsd.day5;

import com.rsd.service.ISysFunctionService;
import com.rsd.service.ISysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test1 {

    @Autowired
    private ISysFunctionService sysFunctionService;

    @Autowired
    private ISysUserService sysUserService;

    @Test
    public  void test1(){
        sysFunctionService.moreDelete(36);
    }

    @Test
    public  void test2(){
        sysUserService.deleteById(1);
    }
}
