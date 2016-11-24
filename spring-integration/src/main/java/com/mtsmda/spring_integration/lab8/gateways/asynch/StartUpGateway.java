package com.mtsmda.spring_integration.lab8.gateways.asynch;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by dminzat on 11/24/2016.
 */
public class StartUpGateway {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/lab8/si-components-asynch.xml");

        /*MessageChannel messageChannel = classPathXmlApplicationContext.getBean("outMessageChannel", MessageChannel.class);
        Message<String> stringMessage = MessageBuilder.withPayload("Hello world from java main method!").build();
        messageChannel.send(stringMessage);*/

        GatewayAsynchI gatewayI = classPathXmlApplicationContext.getBean("firstGateway", GatewayAsynchI.class);
        Future<String> stringFuture = gatewayI.translate("Hello");

        System.out.println(stringFuture.get());
//        System.out.println(stringFuture.get(5, TimeUnit.SECONDS));

        classPathXmlApplicationContext.close();
    }

}