package com.rsd.dao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

@Configuration("classpath:activemq.xml")
public class MessageInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        while (true){

        }
    }
}
