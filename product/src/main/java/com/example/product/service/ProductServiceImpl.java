package com.example.product.service;

import com.example.product.dao.ProductDao;
import com.example.product.entity.Producttest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    RedisServiceImpl redisService;

    @Autowired
    ProductDao productDao;

    @Override
    public int addOne(Producttest producttest) {
        // 添加数据到mysql中

        //如果添加数据库成功  我们将这个数据写入redis

//////
        return 0;
    }

    @Override
    public int deleteOne(String id) {
        //先删除redis缓存

        //再删除mysql中的数据

        //再删除redis缓存


        return 0;
    }

    @Override
    public int updateOne(Producttest producttest) {
        //先修改mysql中的数据


        //查询最新的mysql数据


        //将最新的mysql数据写入redis



        return 0;
    }

    @Override
    public Producttest getOneById(String id) {
        //判断缓存中是否有该商品数据
        boolean exists = redisService.exists(id);
        //如果没有就去数据库查询
        if (exists) {
            log.info("redis缓存中有数据 直接走redis 内容：{}",(Producttest) redisService.get(id));
            return (Producttest) redisService.get(id);


        } else {
            log.info("redis缓存不存在该商品数据  直接走数据库查询  ");
            Producttest producttest = productDao.getOneById(id);
            redisService.set(id,producttest);
            return producttest;
        }


    }
}
