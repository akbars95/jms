package com.mtsmda.jms.activeMQ;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;

/**
 * Created by dminzat on 11/23/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml"})
public class JmsTest {

    /* Constant(s): */
    public static final String AMQ_BROKER_URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "testQueue";

    /* Instance variable(s): */
    protected ConnectionFactory mActiveMQConnectionFactory;
    protected JmsTemplate mJmsTemplate;

    @Before
    public void setUp() {
        mActiveMQConnectionFactory = new ActiveMQConnectionFactory(AMQ_BROKER_URL);
        mJmsTemplate = new JmsTemplate(mActiveMQConnectionFactory);
        final Destination theTestDestination = new ActiveMQQueue(QUEUE_NAME);
        mJmsTemplate.setDefaultDestination(theTestDestination);
        mJmsTemplate.setReceiveTimeout(500L);
    }

    @Test
    public void someIntegrationTest() throws Exception {
        System.out.println("Test starting...");
        sendMessages();
        receiveMessages();
        System.out.println("Test done!");
    }

    protected void sendMessages() {
        for (int i = 1; i <= 10; i++) {
            final int theMessageIndex = i;
            final String theMessageString = "Message: " + theMessageIndex;
            System.out.println("Sending message with text: " + theMessageString);

            mJmsTemplate.send(inJmsSession -> {
                TextMessage theTextMessage = inJmsSession.createTextMessage(theMessageString);
                theTextMessage.setIntProperty("messageNumber", theMessageIndex);
                return theTextMessage;
            });
        }
    }

    protected void receiveMessages() throws Exception {
        Message theReceivedMessage = mJmsTemplate.receive();
        while (theReceivedMessage != null) {
            if (theReceivedMessage instanceof TextMessage) {
                final TextMessage theTextMessage = (TextMessage) theReceivedMessage;
                System.out.println("Received a message with text: " + theTextMessage.getText());
            }
            theReceivedMessage = mJmsTemplate.receive();
        }
        System.out.println("All messages received!");
    }

}