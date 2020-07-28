package com.example.message.web;

import com.example.message.service.PhoneMasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    PhoneMasServiceImpl phoneMasService;

    @Value("${server.port}")
    public int port;

    @Value("${spring.application.name}")
    public String appName;

    @GetMapping("/messageHello")
    public String messageHello(){


        return "我是"+appName+"服务！我的端口是："+port;
    }



    @GetMapping("/sendPhoneMsg/{phoneNum}/{code}")
    public String sendPhoneMsg(@PathVariable("phoneNum") String phoneNum,
                               @PathVariable("code") String code){


        return phoneMasService.sendPhoneMsg(phoneNum,code);
    }


}
