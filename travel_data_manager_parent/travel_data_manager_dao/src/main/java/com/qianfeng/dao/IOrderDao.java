package com.qianfeng.dao;

import com.qianfeng.domain.Member;
import com.qianfeng.domain.Orders;
import com.qianfeng.domain.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDao {

    @Select("select * from orders")
    @Results(id = "baseResult", value = {
            @Result(id = true,column="id",property="id"),
            @Result(column="orderNum",property="orderNum"),
            @Result(column="orderTime",property="orderTime"),
            @Result(column="orderStatus",property="orderStatus"),
            @Result(column="peopleCount",property="peopleCount"),
            @Result(column="payType",property="payType"),
            @Result(column="orderDesc",property="orderDesc"),
            @Result(property="product",column="productId",javaType = Product.class,one = @One(select = "com.qianfeng.dao.IProductDao.findById",fetchType = FetchType.EAGER)),
    })
    List<Orders> findAll(Integer page, Integer pageSize);

    @Select("select * from orders where id = #{id}")
    @Results(id = "baseResult2", value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(property="product",column="productId",javaType = Product.class,one = @One(select = "com.qianfeng.dao.IProductDao.findById",fetchType = FetchType.EAGER)),
            @Result(property="member",column="memberId",javaType = Member.class,one = @One(select = "com.qianfeng.dao.IMemberDao.findById",fetchType = FetchType.EAGER)),
            @Result(property="travellers",column="id",javaType = List.class,many = @Many(select = "com.qianfeng.dao.ITravellersDao.findByOrdersId",fetchType = FetchType.LAZY)),
    })

    Orders findById(String id);
}
