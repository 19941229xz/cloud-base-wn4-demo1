package com.example.user.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("message")
public interface MessageFeignClient {


    @GetMapping("/sendPhoneMsg/{phoneNum}/{code}")
    public String sendPhoneMsg(@PathVariable("phoneNum") String phoneNum,
                               @PathVariable("code") String code);


}
