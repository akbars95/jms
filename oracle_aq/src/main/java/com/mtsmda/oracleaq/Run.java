package com.mtsmda.oracleaq;

import oracle.AQ.*;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by dminzat on 12/8/2016.
 */
public class Run {

    //here is oracle aq doc - https://docs.oracle.com/cd/A97335_02/apps.102/a85456/oracle_a.htm#1001637
    public static void main(String[] args) throws ClassNotFoundException {
        Connection dbConnection;
        AQSession aqSession;
        AQQueueTableProperty aqQueueTableProperty;
        AQQueueProperty aqQueueProperty;
        AQQueueTable aqQueueTable;
        AQQueue aqQueue;

        Class.forName("oracle.jdbc.driver.OracleDriver");
        //"jdbc:oracle:thin:@SERV_URL:SERV_PORT:SID", "login", "pass"
        try (Connection connection = dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "SYSTEM", "system");) {
            connection.setAutoCommit(false);
            System.out.println("Connect!");

            Class.forName("oracle.AQ.AQOracleDriver");
            aqSession = AQDriverManager.createAQSession(dbConnection);
            System.out.println("aqSession success!");

            aqQueueTableProperty = new AQQueueTableProperty("RAW");
            aqQueueTableProperty.setMultiConsumer(false);

            aqQueueTable = aqSession.createQueueTable("SYSTEM", "EXJ_QUEUE_TABLE", aqQueueTableProperty);
            System.out.println("create table is successfully!");

            aqQueueProperty = new AQQueueProperty();

            aqQueue = aqSession.createQueue(aqQueueTable, "EXJ_QUEUE_Q", aqQueueProperty);
            System.out.println("create queue");

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("success done!");
    }

}