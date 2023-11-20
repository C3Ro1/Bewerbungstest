package com.example.bewerbungstest.domain.model.test;

import com.example.bewerbungstest.domain.model.queue.MessageQueue;
import com.example.bewerbungstest.domain.model.queue.QueueTask;
import com.example.bewerbungstest.domain.model.services.MessageService;
import com.example.bewerbungstest.domain.model.services.QueueService;
import com.example.bewerbungstest.domain.model.services.Service;

import org.bson.json.JsonObject;

import org.junit.Test;

public class queueTests {

    private final Service testSender = new QueueService();
    private final MessageService testReceiver = new MessageService();

    @Test
    public void sendMessage_end2endTest_initialise() throws InterruptedException {
        String testContentJson = "{\"test\":\"test\"}";
        JsonObject testContent = new JsonObject(testContentJson);
        QueueTask<Service, Service> queueTask = new QueueTask<>(testSender, testReceiver, testContent);

        MessageQueue messageQueue = new MessageQueue();
        messageQueue.sendMessage(queueTask);
        messageQueue.terminate();
    }

    @Test
    public void sendMessage_end2endTest_notifyCase() throws InterruptedException {
        String testContentJson = "{\"notify\":\"true\"}";
        JsonObject testContent = new JsonObject(testContentJson);
        QueueTask<Service, Service> queueTask = new QueueTask<>(testSender, testReceiver, testContent);

        MessageQueue messageQueue = new MessageQueue();
        messageQueue.sendMessage(queueTask);
        messageQueue.terminate();
    }

    @Test
    public void sendMessage_end2endTest_10SendsCase() throws InterruptedException {
        String testContentJson = "{\"notify\":\"true\"}";
        JsonObject testContent = new JsonObject(testContentJson);
        QueueTask<Service, Service> queueTask = new QueueTask<>(testSender, testReceiver, testContent);

        MessageQueue messageQueue = new MessageQueue();

        for (int i = 0; i < 4; i++) {
            messageQueue.sendMessage(queueTask);
        }
        messageQueue.sendMessage(queueTask);
        messageQueue.sendMessage(queueTask);

        for (int i = 0; i < 4; i++) {
            messageQueue.sendMessage(queueTask);
        }

        messageQueue.terminate();
    }


    @Test
    public void test_sendToQueue() throws InterruptedException {
        String testContentJson = "{\"test\":\"test\"}";
        testReceiver.internalRequest("{\"test\":\"test\"}");
    }

}
