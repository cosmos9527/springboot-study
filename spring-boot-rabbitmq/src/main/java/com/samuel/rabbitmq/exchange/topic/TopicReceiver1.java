package com.samuel.rabbitmq.exchange.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver1 {

    @RabbitListener(queues = "topic.message")
    public void process(String messege){
        System.out.println("topic receiver1 : " + messege);
    }
}
