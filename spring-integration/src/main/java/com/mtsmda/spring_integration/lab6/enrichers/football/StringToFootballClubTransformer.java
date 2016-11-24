package com.mtsmda.spring_integration.lab6.enrichers.football;

import com.mtsmda.spring_integration.lab6.enrichers.Person;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

/**
 * Created by dminzat on 11/24/2016.
 */
public class StringToFootballClubTransformer {

    @Transformer
    public Message<FootballClub> transformToFootballClub(Message<String> inputMessage) {
        String[] split = inputMessage.getPayload().split("\\|\\_\\|");
        return new GenericMessage<>(new FootballClub(split[0], Integer.valueOf(split[1])));
    }

}