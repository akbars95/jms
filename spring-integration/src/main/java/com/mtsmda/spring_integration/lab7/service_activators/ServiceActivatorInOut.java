package com.mtsmda.spring_integration.lab7.service_activators;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

/**
 * Created by dminzat on 11/24/2016.
 */
public class ServiceActivatorInOut {

    public Message<String> process(Message<String> inMessage){
        return new GenericMessage<String>(inMessage.getPayload() + "OUT!");
    }

}