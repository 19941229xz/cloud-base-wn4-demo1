package com.example.order.web;

import com.example.order.httpclient.MessageHttpClient;
import com.example.order.httpclient.MessageHttpClient2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    MessageHttpClient2 client;

    @GetMapping("/orderHello")
    public String orderHello(){

        //用户访问订单接口 orderHello
        // 订单服务再去访问message  messageHello
        // 同步调用  串行执行  异步调用
        /**
         *  访问订单  订单访问消息 消息返回数据给订单
         *  订单才会返回数据给用户
         *
         *  服务依赖
         *  很长的调用链路里面
         *  用户 》A》B》c》D》E
         */
        return client.visitMessageHello();
    }



}
