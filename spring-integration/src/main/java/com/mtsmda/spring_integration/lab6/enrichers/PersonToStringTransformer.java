package com.mtsmda.spring_integration.lab6.enrichers;

import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

/**
 * Created by dminzat on 11/24/2016.
 */
public class PersonToStringTransformer {

    @Transformer
    public Message<String> transform(Message<Person> inputMessage) {
        return new GenericMessage<String>(inputMessage.getPayload().toString());
    }

}