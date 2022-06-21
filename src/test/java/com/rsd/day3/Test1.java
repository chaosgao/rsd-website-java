package com.rsd.day3;

import com.rsd.controller.SysUserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test1 {

    @Autowired
    private SysUserController sysUserController;

    @Test
    public void text1(){
        sysUserController.toUpdatePage(15);
    }

    @Test
    public void text2(){
        sysUserController.list(2);
    }
}
