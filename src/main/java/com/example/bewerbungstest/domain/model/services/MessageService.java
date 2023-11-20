package com.example.bewerbungstest.domain.model.services;

import com.example.bewerbungstest.domain.model.queue.QueueTask;

import com.example.bewerbungstest.facade.handler.QueueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.bson.json.JsonObject;

@Service
public class MessageService extends com.example.bewerbungstest.domain.model.services.Service {

    @Autowired
    public MessageService(){
        QueueHandler.register(this, "messager");
    }

    public void internalRequest(String content) throws InterruptedException {
        JsonObject contentJson = new JsonObject(content);
        QueueService.addMessage(this, contentJson).toRecipient("rewrite");
    }


    @Override
    public QueueTask<com.example.bewerbungstest.domain.model.services.Service, com.example.bewerbungstest.domain.model.services.Service> handleMessage(JsonObject content) {

        System.out.println("MessageService: " + content);
        return new QueueTask<>(this, this, content);
    }
}