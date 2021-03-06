package com.mtsmda.jms.activeMQ.topic;

import com.mtsmda.jms.activeMQ.Helper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dminzat on 12/4/2016.
 */
public class RunSender {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");

        Helper helper = classPathXmlApplicationContext.getBean("helper", Helper.class);
        helper.sendMessageToTheTopic("topic", "This is topic");

        classPathXmlApplicationContext.close();
//        System.err.print("Hello");
    }

}