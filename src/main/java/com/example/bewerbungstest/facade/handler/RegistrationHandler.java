package com.example.bewerbungstest.facade.handler;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController

public class RegistrationHandler {

    @PostMapping("/register")
    public void register(@PathVariable String user) {
        //Todo
        System.out.println("Registered: " + user);
    }
}
