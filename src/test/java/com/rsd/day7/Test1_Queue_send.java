package com.rsd.day7;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;

import javax.jms.*;

public class Test1_Queue_send {

    @Test
    public void send() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://139.9.116.29:61616"); //工厂
        QueueConnection connection = factory.createQueueConnection();
        QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("AAA");
        MessageProducer producer = session.createProducer(queue);
        Message message = session.createTextMessage("Hello");
        producer.send(message);

        producer.close();
        session.close();
        connection.close();
    }
}
