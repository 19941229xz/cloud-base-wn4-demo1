package com.example.sale.web;

import com.example.sale.feign.MessageFeignCilent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleController {


    @Autowired
    MessageFeignCilent cilent;

    @GetMapping("saleHello")
    public String saleHello(){


        return cilent.visitMessageHello();
    }



}
