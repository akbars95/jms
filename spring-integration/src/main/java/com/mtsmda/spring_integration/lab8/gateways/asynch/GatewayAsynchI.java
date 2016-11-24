package com.mtsmda.spring_integration.lab8.gateways.asynch;

import java.util.concurrent.Future;

/**
 * Created by dminzat on 11/24/2016.
 */
public interface GatewayAsynchI {

    Future<String> translate(String text);

}