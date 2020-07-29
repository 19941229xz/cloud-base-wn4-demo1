package com.example.product;

import com.example.product.dao.ProductDao;
import com.example.product.entity.Producttest;
import com.example.product.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ProductApplicationTests {

    @Autowired
    ProductDao productDao;

    @Autowired
    ProductServiceImpl productService;

    @Test
    void contextLoads() {

        productDao.addOne(new Producttest("1","product1"));


    }

    @Test
    public void testProductService(){
        log.info(productService.getOneById("1").toString());
    }

}
