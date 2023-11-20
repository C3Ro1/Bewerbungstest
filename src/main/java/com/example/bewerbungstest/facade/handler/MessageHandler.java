package com.example.bewerbungstest.facade.handler;


import com.example.bewerbungstest.domain.model.Message;

import com.example.bewerbungstest.domain.model.queue.QueueTask;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class MessageHandler{

//TODO: Implement MessageHandler
    private static final Logger LOGGER = Logger.getLogger(MessageHandler.class.getName());


    void handleMessage(Message message) {
        if(!message.isMessageEdited()){
            LOGGER.log(Level.INFO, "Message");
            sendMessageToService(message, "GPTService").subscribe();
        }
    }


    //TODO
    @PostMapping("/messageSend")
    Mono<Message> sendMessage(Message message) {
        return Mono.just(message);
    }

    //TODO
    @GetMapping("/messageGet")
    Mono<Message> getMessage(Message message) {
        return Mono.just(message);
    }


    Mono<Void> sendMessageToService(Message message, String service) {
        return Mono.create(sink -> {
            QueueHandler.send(message.getMessageText(), service);

        });


}
}
