package com.samuel.web;

import com.samuel.rabbitmq.hello.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {

    @Autowired
    private HelloSender helloSender;

//    @GetMapping("/hello")
////    public String hello(){
////        helloSender.send();
////        return "ok!";
////    }

}
