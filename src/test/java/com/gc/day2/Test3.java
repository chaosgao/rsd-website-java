package com.gc.day2;

import com.rsd.controller.SysUserController;

import com.rsd.service.ISysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test3 {

    @Autowired
    private SysUserController sysUserController;

    @Autowired
    private ISysUserService sysUserService;

    @Test
    public void aa(){
        sysUserController.toUpdatePage(10);
    }

    @Test
    public void bb(){
       sysUserService.getById(9);
    }
}
