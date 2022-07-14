package com.rsd.controller;

import com.rsd.bean.Message;
import com.rsd.service.IMessageService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jms.JMSException;
import javax.jms.Session;
import java.util.List;

@Controller
@RequestMapping("message")
public class MessageController implements InitializingBean {
    @Autowired
    private IMessageService messageService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("queue1")
    private ActiveMQQueue activeMQQueue;


    @GetMapping("list")
    public List<Message> list(){
        return messageService.queryList();
    }

    @PostMapping("insert")
    public void insert(Message message){
        messageService.insert(message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        while (true){
            jmsTemplate.send(activeMQQueue, new MessageCreator() {
                @Override
                public javax.jms.Message createMessage(Session session) throws JMSException {
                    session.createObjectMessage();
                    return null;
                }
            });
        }
    }
}
