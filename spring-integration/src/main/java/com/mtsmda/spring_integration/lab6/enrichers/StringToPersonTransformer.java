package com.mtsmda.spring_integration.lab6.enrichers;

import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

/**
 * Created by dminzat on 11/24/2016.
 */
public class StringToPersonTransformer {

    @Transformer
    public Message<Person> transform(Message<String> inputMessage) {
        String payload = inputMessage.getPayload();
        Person person = new Person();

        String[] split = payload.split("\\|\\_\\|");
        person.setFirstName(split[0]);
        person.setLastName(split[1]);
        person.setAge(Integer.valueOf(split[2]));

        return new GenericMessage<Person>(person);
    }

}