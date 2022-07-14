package com.rsd.day7;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;

import javax.jms.*;

public class Test4_Topic_receive {

    @Test
    public void receive1() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        QueueConnection connection = factory.createQueueConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic("BBB");
        MessageConsumer consumer = session.createConsumer(topic);
        while (true){
            Message message = consumer.receive();
            if (message != null){
                TextMessage textMessage = (TextMessage)message;

                System.out.println(textMessage.getText());
            }else {
                break;
            }
        }
        consumer.close();
        session.close();
        connection.close();
    }
}
