package com.example.order.httpclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MessageHttpClient {


    public String visitMessageHello(){
        RestTemplate restTemplate = new RestTemplate();
        //getForObject(访问地址，返回结果的类型)
        return restTemplate.getForObject("http://localhost:1010/messageHello"
        ,String.class);
    }



}
