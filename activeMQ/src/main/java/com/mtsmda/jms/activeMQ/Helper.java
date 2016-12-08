package com.mtsmda.jms.activeMQ;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by dminzat on 11/28/2016.
 */
@Component("helper")
public class Helper {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private TopicConnectionFactory topicConnectionFactory;

    public void sendMessageToTheTopic(String queueName, String content) {
        try {
            TopicConnection topicConnection = topicConnectionFactory.createTopicConnection();
            topicConnection.start();
            TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = topicSession.createTopic(queueName);
            MessageProducer producer = topicSession.createProducer(topic);
            TextMessage textMessage = topicSession.createTextMessage();
            textMessage.setText(content);
            producer.send(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receiveMessageToTheTopic(String queueName) {
        try {
            TopicConnection topicConnection = topicConnectionFactory.createTopicConnection();
            topicConnection.start();
            TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = topicSession.createTopic(queueName);
            TopicSubscriber subscriber = topicSession.createSubscriber(topic);
            /*subscriber.setMessageListener(message -> {
                try {
                    System.out.println(LocalDateTime.now() + " - " + ((TextMessage) message).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            });*/
            while (true) {
                System.out.println("Message - " + ((TextMessage)subscriber.receiveNoWait()).getText());
                Thread.sleep(1_000);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String queueName, String content) {
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(queueName);
            MessageProducer producer = session.createProducer(queue);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText(content);
            producer.send(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T extends Serializable> void sendMessageObject(String queueName, T object) {
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(queueName);
            MessageProducer producer = session.createProducer(queue);
            ObjectMessage objectMessage = session.createObjectMessage();
            objectMessage.setObject(object);
            producer.send(objectMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String receiveMessage(String queueName) {
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(queueName);
            MessageConsumer consumer = session.createConsumer(queue);
            return ((TextMessage) consumer.receive()).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T extends Serializable> T receiveMessageObject(String queueName, Class<T> tClass) {
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(queueName);
            MessageConsumer consumer = session.createConsumer(queue);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    ActiveMQObjectMessage activeMQObjectMessage = (ActiveMQObjectMessage) message;
                    try {
                        System.out.println("SOURCE" + activeMQObjectMessage.getObject());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
            while (true) {

            }
            /*ObjectMessage objectMessage = session.createObjectMessage();
            return (T) objectMessage.getObject();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}