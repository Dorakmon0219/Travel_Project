package com.qianfeng.dao;

import com.qianfeng.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {

    @Select("select * from product")
    List<Product> findAll();

    @Insert("insert into product(id,productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus) values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void addProduct(Product product);

    @Select("select * from product where id = #{id}")
    Product findById(String id);

    @Update("update product set id=#{id}, productNum=#{productNum},productName=#{productName},cityName=#{cityName},DepartureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id = #{id}")
    void updateProduct(Product product);

    @Delete("delete from product where id = #{id}")
    void deleteById(String id);
}
