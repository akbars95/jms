package com.mtsmda.spring_integration.lab7.service_activators;

import org.springframework.messaging.Message;

/**
 * Created by dminzat on 11/24/2016.
 */
public class MultipleServiceActivator {

    public void first(Message<String> inMessage){
        System.out.println("SOUT = " + inMessage);
    }

    public String second(){
        return "\nSECOND!\n";
    }

}