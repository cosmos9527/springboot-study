package com.samuel.rabbitmq.object;

import com.samuel.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ObjReceiver {

    @RabbitListener(queues = "object")
    public void process(User user){
        System.out.println("Obj Receiver : " + user);
    }
}
