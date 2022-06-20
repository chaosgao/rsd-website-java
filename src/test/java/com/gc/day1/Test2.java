package com.gc.day1;

import com.rsd.bean.SysFunction;
import com.rsd.bean.SysRole;
import com.rsd.service.impl.SysFunctionServiceImpl;
import com.rsd.service.impl.SysRoleServiceImpl;
import com.rsd.service.impl.SysUserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        String[] names = context.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }
        SysRoleServiceImpl sysRoleService = context.getBean(SysRoleServiceImpl.class);
        SysRole sysRole = new SysRole();

        sysRole.setName("dnaojnkdjank");
        sysRoleService.insert(sysRole);
    }
}
