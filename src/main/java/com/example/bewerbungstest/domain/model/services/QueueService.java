package com.example.bewerbungstest.domain.model.services;

import com.example.bewerbungstest.domain.model.queue.MessageQueue;
import com.example.bewerbungstest.domain.model.queue.QueueTask;

import com.example.bewerbungstest.facade.handler.QueueHandler;
import org.bson.json.JsonObject;


import org.springframework.stereotype.Service;

@Service
public class QueueService extends com.example.bewerbungstest.domain.model.services.Service{


    private static final MessageQueue MASSAGERS = new MessageQueue();

    public static QueueHandler addMessage(com.example.bewerbungstest.domain.model.services.Service Sender, JsonObject content) {
        return (String RecipientRequest) -> {
            com.example.bewerbungstest.domain.model.services.Service Recipient = lookup(RecipientRequest);
            MASSAGERS.sendMessage(new QueueTask<>(Sender, Recipient, content));};
    }

    private static com.example.bewerbungstest.domain.model.services.Service lookup(String recipientRequest) {
        return null;
    }

    @Override
    public QueueTask<com.example.bewerbungstest.domain.model.services.Service, com.example.bewerbungstest.domain.model.services.Service> handleMessage(
            JsonObject content) {
        System.out.println("QueueService: " + content);
        return new QueueTask<>(this, this, content);
    }
}
