package com.example.product.dao;

import com.example.product.entity.Producttest;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductDao {

    @Insert("insert into producttest (id,productName)values(#{id},#{productName})")
    public int addOne(Producttest producttest);

    @Delete("delete from producttest where id = #{id}")
    public int deleteOne(String id);

    @Update("update producttest set productName=#{productName} where id=#{id}")
    public int updateOne(Producttest producttest);

    @Select("select * from producttest where id=#{id}")
    public Producttest getOneById(String id);

}
