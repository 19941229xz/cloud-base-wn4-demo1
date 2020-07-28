package com.example.eureka.listener;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class EurekaListener {


    /**
     * spring:
     *   application:
     *     name: order
     * @param event
     */
    @EventListener
    public void instanceCancelListen(EurekaInstanceCanceledEvent event){
        System.out.println("监听到了服务下线");
        System.out.println(event.getAppName()); // 服务名称 application name
        System.out.println(event.getServerId());

    }


    @EventListener
    public void instanceRegisterListen(EurekaInstanceRegisteredEvent event){
        System.out.println("我监听到了 服务注册事件");
        System.out.println(event.getInstanceInfo().getAppName());
        System.out.println(event.getInstanceInfo().getInstanceId());
    }


}
