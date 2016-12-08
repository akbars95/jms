package com.mtsmda.camel.spring;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dminzat on 12/1/2016.
 */
public class CamelSpringExample {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        try {
            SpringCamelContext springCamelContext = SpringCamelContext.springCamelContext(applicationContext, false);
            ProducerTemplate producerTemplate = springCamelContext.createProducerTemplate();
            springCamelContext.start();
            producerTemplate.sendBody("activemq:test:queue", "Hello world, ");
            springCamelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}