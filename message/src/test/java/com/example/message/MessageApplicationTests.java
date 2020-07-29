package com.example.message;

import com.example.message.service.RedisServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageApplicationTests {

    @Autowired
    RedisServiceImpl redisService;

    @Test
    void testRedisSet() {

        redisService.set("330","123456");

    }

}
