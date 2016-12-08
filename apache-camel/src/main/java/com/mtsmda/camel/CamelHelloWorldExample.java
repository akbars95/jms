package com.mtsmda.camel;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by dminzat on 12/1/2016.
 */
public class CamelHelloWorldExample {

    public static void main(String[] args) {
        CamelContext camelContext = new DefaultCamelContext();
        try {
            camelContext.addComponent("activemq", ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false"));
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("activemq:queue:test:queue").to("stream:out");
                }
            });

            ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
            camelContext.start();
            producerTemplate.sendBody("activemq:test:queue", "Hello world");

            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("timer://myTimer?period=2000").setBody().simple("Hello world camel fired at ${header.firedTime}").to("stream:out");
                }
            });
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                camelContext.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}