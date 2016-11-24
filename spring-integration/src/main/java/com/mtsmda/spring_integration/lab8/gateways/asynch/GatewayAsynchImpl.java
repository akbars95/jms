package com.mtsmda.spring_integration.lab8.gateways.asynch;

import jdk.management.resource.internal.FutureWrapper;

import java.util.concurrent.*;

/**
 * Created by dminzat on 11/24/2016.
 */
public class GatewayAsynchImpl implements GatewayAsynchI {

    @Override
    public Future<String> translate(String text) {
        return new Future<String>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public String get() throws InterruptedException, ExecutionException {
                return text.toUpperCase().concat("FUTURE");
            }

            @Override
            public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return get();
            }
        };
    }

}