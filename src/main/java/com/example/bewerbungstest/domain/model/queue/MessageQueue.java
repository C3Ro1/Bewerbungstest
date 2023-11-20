package com.example.bewerbungstest.domain.model.queue;

import com.example.bewerbungstest.domain.model.services.QueueService;
import com.example.bewerbungstest.domain.model.services.Service;

import org.bson.BsonDocument;
import org.bson.json.JsonObject;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


@Component("messageQueue")
public class MessageQueue {
    private static final AtomicInteger CAP = new AtomicInteger(10);
    private static final AtomicInteger THREADCAP = new AtomicInteger(2);
    // private final AtomicInteger numberOfExecution = new AtomicInteger(0); //Debugging purposes only


    private final BlockingQueue<QueueTask<Service, Service>> communicationQueue = new LinkedBlockingQueue<>(CAP.get());
    private final Queue<QueueTask<Service, Service>> RepressedQueue = new PriorityQueue<>();
    private final ExecutorService queueExecutor = Executors.newFixedThreadPool(THREADCAP.get());

    @Async
    public void sendMessage(QueueTask<Service, Service> message) throws InterruptedException {

        if(communicationQueue.isEmpty()){
            communicationQueue.put(message);
            startQueue();
        } else if(communicationQueue.size() < CAP.get()) {

            communicationQueue.put(message);
        } else {
            RepressedQueue.add(message);
        }
    }


    private QueueTask<Service, Service> receiveMessage() throws InterruptedException {
        return communicationQueue.take();
    }


    @Async
    void startQueue(){
        while (!queueExecutor.isTerminated()) {
            queueExecutor.submit(() -> {
                try {

                    if(communicationQueue.size()<CAP.get() &&!RepressedQueue.isEmpty()){
                        communicationQueue.put(RepressedQueue.poll());
                    }

                    QueueTask<Service, Service> message = receiveMessage();

                    handleQueue(message);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            if (communicationQueue.isEmpty()){
                break;
            }
        }
    }

    public void terminate(){
        queueExecutor.shutdown();
    }


    @Async
    void handleQueue(QueueTask<Service, Service> message) {
            QueueTask<Service, Service> result = message.getRecipient().handleMessage(message.getContent());

            System.out.println(result.getContent().toBsonDocument().getString("notify").getValue());

            if(result.getContent().toBsonDocument().getString("notify").getValue().equals("true")){

                BsonDocument contentUpdate = result.getContent().toBsonDocument();
                contentUpdate.remove("notify");
                message.getSender().handleMessage(new JsonObject(contentUpdate.toJson()));

            }
    }

}
