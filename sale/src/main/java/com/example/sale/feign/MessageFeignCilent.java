package com.example.sale.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("message")  //配置服务集群的名称 可以小写
public interface MessageFeignCilent {

    @RequestMapping("/messageHello")
    public String visitMessageHello();

}
