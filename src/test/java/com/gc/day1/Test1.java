package com.gc.day1;

import com.rsd.bean.SysUser;
import com.rsd.service.ISysUserService;
import com.rsd.service.impl.SysUserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");

        String[] names = factory.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }

        ISysUserService userService = factory.getBean(SysUserServiceImpl.class);
//        List<SysUser> list = userService.queryList();
//        System.out.println(list);

        SysUser sysUser1 = userService.getById(2);
        System.out.println(sysUser1);

        SysUser sysUser = new SysUser();
        sysUser.setLoginName("aaaaaa");
        sysUser.setPassword("123456");
        sysUser.setRealName("AAAAAA");
        sysUser.setId(2);

        factory.close();
    }
}
