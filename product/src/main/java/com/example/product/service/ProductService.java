package com.example.product.service;

import com.example.product.entity.Producttest;

public interface ProductService {

    public int addOne(Producttest producttest);

    public int deleteOne(String id);

    public int updateOne(Producttest producttest);

    public Producttest getOneById(String id);






}
