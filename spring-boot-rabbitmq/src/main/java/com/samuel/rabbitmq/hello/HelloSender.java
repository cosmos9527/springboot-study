package com.samuel.rabbitmq.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void send(int i){
        String msg = "Hello! --> " + new Date() + " : " + i;
        System.out.println("Sender : " + msg);
        this.amqpTemplate.convertAndSend("Hello",msg);
    }
}
