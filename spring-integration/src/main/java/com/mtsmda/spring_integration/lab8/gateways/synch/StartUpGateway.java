package com.mtsmda.spring_integration.lab8.gateways.synch;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dminzat on 11/24/2016.
 */
public class StartUpGateway {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/lab8/si-components.xml");

        /*MessageChannel messageChannel = classPathXmlApplicationContext.getBean("outMessageChannel", MessageChannel.class);
        Message<String> stringMessage = MessageBuilder.withPayload("Hello world from java main method!").build();
        messageChannel.send(stringMessage);*/

        GatewayI gatewayI = classPathXmlApplicationContext.getBean("firstGateway", GatewayI.class);
        System.out.println(gatewayI.translate("Hello"));

        classPathXmlApplicationContext.close();
    }

}