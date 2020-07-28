package com.example.order.httpclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MessageHttpClient2 {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    public String visitMessageHello(){

        RestTemplate restTemplate = new RestTemplate();

        // 传入的参数是 服务集群的名称 负载均很组件会随机给我们返回集群中的一个实例
        ServiceInstance serviceInstance = loadBalancerClient
                .choose("MESSAGE");
        // 根据 实例信息 完成 请求地址的拼接
        String url = String.format("http://localhost:%s/messageHello",serviceInstance.getPort());

        return restTemplate.getForObject(url,String.class);

    }

}
