package com.samuel.rabbitmq.object;

import com.samuel.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjSender {

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void sendObj(User user){
        System.out.println("send obj : " + user.toString());
        this.amqpTemplate.convertAndSend("object",user);
    }
}
