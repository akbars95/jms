package com.mtsmda.jms.activeMQ;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.xbean.BrokerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by dminzat on 11/23/2016.
 */
public class ActiveMQConnection {

    public static void main(String[] args) {
        try {
            BrokerService brokerService = new BrokerService();
            brokerService.addConnector("tcp://localhost:61616");
            brokerService.start();
            System.out.println("start");

            String queueName = "SIMPLE";
            Helper helper = new Helper();
            helper.sendMessage(queueName, "Simple Text");

            String s = helper.receiveMessage(queueName);
            System.out.println("received - " + s);


            Thread.sleep(1_000);
            brokerService.stop();
            System.out.println("stop");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}