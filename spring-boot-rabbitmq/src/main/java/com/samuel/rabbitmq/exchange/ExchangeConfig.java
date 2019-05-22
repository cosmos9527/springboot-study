package com.samuel.rabbitmq.exchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeConfig {

    final static String message = "topic.message";
    final static String messages = "topic.messages";

    @Bean
    public Queue queueMessage(){
        return new Queue(ExchangeConfig.message);
    }

    @Bean
    public Queue queueMessages(){
        return new Queue(ExchangeConfig.messages);
    }

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("exchange_topic");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage,TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.messages");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages,TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessages).to(topicExchange).with("topic.#");
    }

}
