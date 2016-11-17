package com.mtsmda.spring_integration.lab3.filters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dminzat on 11/17/2016.
 */
public class StartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/lab3/si-components_lab3.xml");
        for (; true; ) {

        }
    }

}