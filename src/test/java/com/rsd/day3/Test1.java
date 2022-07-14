package com.rsd.day3;

import com.rsd.bean.Behavior;
import com.rsd.bean.SysRole;
import com.rsd.controller.SysUserController;
import com.rsd.service.IBehaviorService;
import com.rsd.service.ISysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test1 {

    @Autowired
    private SysUserController sysUserController;

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private IBehaviorService behaviorService;

    @Test
    public void text1() {
        sysUserController.toUpdatePage(15);
    }

    @Test
    public void text2() {
        sysUserController.list(2);
    }

    @Test
    public void text3() {
        List<SysRole> list = sysRoleService.queryList();
        System.out.println(list);
    }

    @Test
    public void text4() {
        List<Behavior> list = behaviorService.treeList1();
        System.out.println(list);
    }
}
