package com.mtsmda.spring_integration.lab5.routers;

import org.springframework.messaging.Message;

/**
 * Created by dminzat on 11/22/2016.
 */
public class CustomRouter {

    public String router(Message<String> stringMessage){
        if(stringMessage.getPayload().length() > 10){
            return "big10Length";
        }
        return "less10Length";
    }

}