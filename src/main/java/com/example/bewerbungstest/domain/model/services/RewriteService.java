package com.example.bewerbungstest.domain.model.services;

import com.example.bewerbungstest.facade.handler.QueueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bewerbungstest.domain.model.queue.QueueTask;

import org.bson.json.JsonObject;

@Service
public class RewriteService extends com.example.bewerbungstest.domain.model.services.Service{

    @Autowired
    public RewriteService(){
        QueueHandler.register(this, "rewriter");
    }


    @Override
    public QueueTask<com.example.bewerbungstest.domain.model.services.Service, com.example.bewerbungstest.domain.model.services.Service> handleMessage(JsonObject content) {
        return new QueueTask<>(this, this, content);
    }
}
