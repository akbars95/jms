package com.mtsmda.spring_integration.lab5.routers;

import org.springframework.integration.annotation.Router;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by dminzat on 11/22/2016.
 */
@Component("annotatedCustomRouter")
public class AnnotatedCustomRouter {

    @Router
    public String customRouter(Message<String> stringMessage) {
        if (stringMessage.getPayload().endsWith(".xml")) {
            return "xmlFile";
        }
        return "textFile";
    }

}