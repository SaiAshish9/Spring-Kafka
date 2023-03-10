package com.sai.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Producer producer;

    @Autowired
    public Controller(Producer producer) {
        this.producer = producer;
    }
//    because of private final we had to add
//    @Autowired here.

    @PostMapping("/publish")
    public void messageToTopic(@RequestParam("message") String message){
        producer.sendMessage(message);
    }
}

