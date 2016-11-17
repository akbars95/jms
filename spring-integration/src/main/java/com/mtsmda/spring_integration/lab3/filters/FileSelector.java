package com.mtsmda.spring_integration.lab3.filters;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

import java.io.File;

/**
 * Created by dminzat on 11/17/2016.
 */
public class FileSelector implements MessageSelector {

    @Override
    public boolean accept(Message<?> message) {
        return message.getPayload() instanceof File && ((File) message.getPayload()).getName().startsWith("msg");
    }

}