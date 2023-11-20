package com.example.bewerbungstest.domain.model.queue;

import com.example.bewerbungstest.domain.model.services.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;

import org.bson.json.JsonObject;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Getter
public class QueueTask<Sender, Recipient> {
    private final Sender sender;
    private final Recipient recipient;
    private final JsonObject content;
}
