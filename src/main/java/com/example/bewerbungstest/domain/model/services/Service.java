package com.example.bewerbungstest.domain.model.services;

import com.example.bewerbungstest.domain.model.queue.QueueTask;

import org.bson.json.JsonObject;



public abstract class Service {
    public abstract QueueTask<Service,Service> handleMessage(JsonObject content);
}
