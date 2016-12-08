package com.mtsmda.jms.activeMQ;

import com.mtsmda.jms.activeMQ.domain.Person;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;

/**
 * Created by dminzat on 11/28/2016.
 */
public class Run {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
//        embeddedActiveMQ(applicationContext);
        Helper helper = applicationContext.getBean("helper", Helper.class);
        helper.sendMessage("new", "Hello");
        String s = helper.receiveMessage("new");
        System.out.println("received - " + s);

        helper.sendMessageToTheTopic("newTopic", "This is Topic!");

        applicationContext.close();
    }

    private static void embeddedActiveMQ(ClassPathXmlApplicationContext applicationContext){
        Helper helper = applicationContext.getBean("helper", Helper.class);
        try {
            BrokerService brokerService = new BrokerService();
            brokerService.addConnector("tcp://localhost:61617");
            brokerService.start();
            System.out.println("start");

            String queueName = "SIMPLE";

            System.out.println("TEXT!!!!!!!!!!!!!!!!!!");
            helper.sendMessage(queueName, "Simple Text");
            String s = helper.receiveMessage(queueName);
            System.out.println("received - " + s);

            System.out.println("OBJECT!!!!!!!!!!!!!!!!!!");
            helper.sendMessageObject(queueName + "1", new Person("Ionel", 29));
            Person person = helper.receiveMessageObject(queueName + "1", Person.class);
            System.out.println(person);

            brokerService.stop();
            System.out.println("stop");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}