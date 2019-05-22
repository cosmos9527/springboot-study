package com.samuel.rabbitmq.exchange.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String content = "topic : i am message all";
        System.out.println("topic sender : " + content);
        this.amqpTemplate.convertAndSend("exchange_topic","topic.1",content);
    }

    public void  sendMessage(){
        String content = "topic : i am message 1";
        System.out.println("topic sender : " + content);
        this.amqpTemplate.convertAndSend("exchange_topic","topic.message",content);
    }

    public void  sendMessages(){
        String content = "topic : i am messages 2";
        System.out.println("topic sender : " + content);
        this.amqpTemplate.convertAndSend("exchange_topic","topic.messages",content);
    }
}
