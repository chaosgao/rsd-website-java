package com.rsd.day7;

import com.rsd.bean.SysUser;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;
import javax.jms.*;

@SpringJUnitConfig
@ContextConfiguration("classpath:activeMQ.xml")
public class Test5 {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("queue1") //注解的第一种方式 注解里加上id名
    private ActiveMQQueue activeMQQueue;

    @Resource //自动注入第二种方式，加上注解，直接写id名
    private ActiveMQTopic topic2;

    @Test
    public void send1(){
        jmsTemplate.send(activeMQQueue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                SysUser sysUser = new SysUser();
                sysUser.setId(2);
                sysUser.setLoginName("明天");
                return session.createObjectMessage(sysUser);
            }
        });
    }

    @Test
    public void send2(){
        jmsTemplate.send(topic2, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("VVV");
            }
        });
    }

    @Test
    public void receive1() throws JMSException {
        while (true){
            Message message = jmsTemplate.receive(activeMQQueue);
            ObjectMessage objectMessage = (ObjectMessage) message;
            SysUser sysUser = (SysUser) objectMessage.getObject();
            System.out.println(sysUser.getId() + "++++" +sysUser.getLoginName());
        }
    }

    @Test
    public void receive2() throws JMSException {
        while (true){
            Message message = jmsTemplate.receive(topic2);
            TextMessage textMessage = (TextMessage) message;
            System.out.println(textMessage.getText());
        }
    }
}
