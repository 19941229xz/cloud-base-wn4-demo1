package com.example.sale;

import com.example.sale.feign.MessageFeignCilent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SaleApplicationTests {

    @Autowired
    MessageFeignCilent cilent;

    @Test
    void testOPenfeignVisitmessage() {
        System.out.println(cilent.visitMessageHello());

    }

}
