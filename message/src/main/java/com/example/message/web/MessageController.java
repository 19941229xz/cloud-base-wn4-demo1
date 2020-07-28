package com.example.message.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Value("${server.port}")
    public int port;

    @Value("${spring.application.name}")
    public String appName;

    @GetMapping("/messageHello")
    public String messageHello(){


        return "我是"+appName+"服务！我的端口是："+port;
    }


}
