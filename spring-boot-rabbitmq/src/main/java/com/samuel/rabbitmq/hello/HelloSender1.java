package com.samuel.rabbitmq.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender1 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int i){
        String msg = "Hello! --> " + new Date() + " : " + i;
        System.out.println("Sender1 : " + msg);
        this.amqpTemplate.convertAndSend("Hello",msg);
    }
}
