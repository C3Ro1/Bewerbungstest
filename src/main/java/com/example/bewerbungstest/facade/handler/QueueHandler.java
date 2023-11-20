package com.example.bewerbungstest.facade.handler;

import com.example.bewerbungstest.domain.model.queue.MessageQueue;
import com.example.bewerbungstest.domain.model.services.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public interface QueueHandler {
    Map<String, Service> Listeners = new HashMap<>();

    static void send(String messageText, String service) {

    }


    void toRecipient(String Recipient) throws InterruptedException;

    default Service lookup(String Recipient) throws InterruptedException{
        return Listeners.getOrDefault(Recipient,null);
    };

    static void register(Service service, String callByName){
        Listeners.put(callByName, service);
    }


}
