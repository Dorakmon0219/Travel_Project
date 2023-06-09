package com.qianfeng.dao;

import com.qianfeng.domain.Member;
import com.qianfeng.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITravellersDao {
    @Select("select * from traveller t,order_traveller ot where ot.travellerId = t.id and ot.orderid = #{id}")
    Traveller findByOrdersId(String id);
}
