package com.example.bewerbungstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BewerbungstestApplication {


    public static void main(String[] args) {

        SpringApplication.run(BewerbungstestApplication.class, args);
    }

}

//first steps Messaging Service
//1. create a new abstract class called Message
//1.1. create a field called MessageId with a unique hexadecimal value
//1.1.1 create a reactive method called generateMessageId
//1.1.1.a) create a new unique, but random hexadecimal value
//1.1.1.b) add to database
//1.1.1.c) return the value
//1.2. create a field called MessageText
//1.3. create a field called MessageDate
//1.4. create a field called MessageAuthor
//1.5. create a field called MessageReceiver
//1.6. create a field called MessageStatus
//1.8. create a field called MessageEdited
//1.9. create a logger using mongodb
//1.9.1 download mongodb



//2. create a new class called MessageController in the controller package
//3. create a new class called MessageService in the service package in the domain package
//4. create a new class called MessageRepository in the repository package in the domain package
//5. create a new class called MessageDTO in the dto package in the domain package
//6. create a new class called MessageMapper in the mapper package in the domain package
//7. create a new class called MessageServiceImpl in the service package in the domain package
//8. create a new class called MessageServiceImplTest in the service package in the domain package
//9. create a mongodb database called messages

