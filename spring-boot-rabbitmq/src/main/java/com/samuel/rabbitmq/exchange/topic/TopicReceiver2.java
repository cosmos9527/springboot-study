package com.samuel.rabbitmq.exchange.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver2 {

    @RabbitListener(queues = "topic.messages")
    public void process(String messeges){
        System.out.println("topic receiver2 : " + messeges);
    }
}
