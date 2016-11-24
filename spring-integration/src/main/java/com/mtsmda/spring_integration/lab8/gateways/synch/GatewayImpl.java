package com.mtsmda.spring_integration.lab8.gateways.synch;

/**
 * Created by dminzat on 11/24/2016.
 */
public class GatewayImpl implements GatewayI{

    @Override
    public String translate(String text) {
        return text.toUpperCase().concat(", Barca!");
    }

}