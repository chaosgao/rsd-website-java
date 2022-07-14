package com.rsd.day7;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;

import javax.jms.*;

public class Test3_Topic_send {

    @Test
    public void send() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616"); //工厂
        QueueConnection connection = factory.createQueueConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic("BBB");
        MessageProducer producer = session.createProducer(topic);
        Message message = session.createTextMessage("Hello");
        producer.send(message);

        producer.close();
        session.close();
        connection.close();
    }
}
