package com.example.bewerbungstest.domain.model.services;

import com.example.bewerbungstest.facade.handler.QueueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bewerbungstest.domain.model.queue.QueueTask;

import org.bson.json.JsonObject;


@Service
public class LoggerService extends com.example.bewerbungstest.domain.model.services.Service{

    @Autowired
    LoggerService(){
        QueueHandler.register(this,"logger");
    }

    @Override
    public QueueTask<com.example.bewerbungstest.domain.model.services.Service, com.example.bewerbungstest.domain.model.services.Service> handleMessage(JsonObject content) {
        System.out.println("LoggerService: " + content);
        return new QueueTask<>(this, this, content);
    }
}
