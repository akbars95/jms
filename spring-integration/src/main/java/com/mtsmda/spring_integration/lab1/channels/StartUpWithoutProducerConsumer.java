package com.mtsmda.spring_integration.lab1.channels;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by dminzat on 11/16/2016.
 */
public class StartUpWithoutProducerConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/lab1/si-components-without-producer-consumer.xml");

        MessageChannel messageChannel = classPathXmlApplicationContext.getBean("messageChannel", MessageChannel.class);

        Message<String> message1 = MessageBuilder.withPayload("Hello world - first time!").build();
        Message<String> message2 = MessageBuilder.withPayload("Hello world - second time!").build();
        Message<String> message3 = MessageBuilder.withPayload("Hello world - third time!").build();
        System.out.println("sending message 1");
        messageChannel.send(message1);
        System.out.println("sending message 2");
        messageChannel.send(message2);
        System.out.println("sending message 3");
        messageChannel.send(message3);
    }

}