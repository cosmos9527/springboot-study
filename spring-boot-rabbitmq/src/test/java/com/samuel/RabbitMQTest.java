package com.samuel;

import com.samuel.model.User;
import com.samuel.rabbitmq.exchange.topic.TopicSender;
import com.samuel.rabbitmq.hello.HelloSender;
import com.samuel.rabbitmq.hello.HelloSender1;
import com.samuel.rabbitmq.object.ObjSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private HelloSender helloSender;
    @Autowired
    private HelloSender1 helloSender1;

    @Autowired
    private ObjSender objSender;

    @Autowired
    private TopicSender topicSender;

//    @Test
//    public void hello(){
//        helloSender.send();
//    }

    @Test
    public void oneToMany(){
        for(int i = 0; i < 10;i++){
            helloSender.send(i);
        }
    }

    @Test
    public void manyToMany(){
        for(int i = 0; i < 10;i++){
            helloSender.send(i);
            helloSender1.send(i);
        }
    }

    @Test
    public void sendObj(){
        User user = new User();
        user.setId(1L);
        user.setUserName("Jerry");
        user.setPassword("123456");
        user.setAge(23);

        objSender.sendObj(user);
    }

    @Test
    public void topic(){
//        topicSender.send();
//        topicSender.sendMessage();
        topicSender.sendMessages();
    }
}
