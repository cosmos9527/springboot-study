package com.samuel.rabbitmq.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "Hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String text){
        System.out.println("HelloReceiver : " + text);
    }
}
