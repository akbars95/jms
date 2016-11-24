package com.mtsmda.spring_integration.lab6.enrichers.football;

import org.springframework.messaging.Message;

/**
 * Created by dminzat on 11/24/2016.
 */
public class FootballClubEnricher {

    public String defineNextPath(Message<FootballClub> footballClubMessage){
        int place = footballClubMessage.getPayload().getPlace();

        if(place >= 1 && place <= 4){
            return "Champions League";
        }else if(place >= 5 && place <= 7){
            return "Europa League";
        }else if(place >= 8 && place <= 17){
            return "remain in this division";
        }else{
            return "go to the lower division";
        }
    }

}