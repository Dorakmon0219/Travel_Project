package com.qianfeng.dao;

import com.qianfeng.domain.HotelInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHotelInfoDao {

    @Select("select * from hotel_info")
    List<HotelInfo> findAll();

    @Insert("insert into hotel_info(hotelId,hotelName,address,phoneNum,contacter,price,hotelType) values(#{hotelId},#{hotelName},#{address},#{phoneNum},#{contacter},#{price},#{hotelType})")
    void save(HotelInfo hotelInfo);

    @Delete("delete from hotel_info where hotelId = #{id}")
    void deleteId(String id);

    @Select("select * from hotel_info where hotelId = #{id}")
    HotelInfo finById(String id);

    @Update("update hotel_info set hotelName = #{hotelName}, address = #{address}, phoneNum = #{phoneNum}, contacter = #{contacter}, price = #{price}, hotelType = #{hotelType} where hotelId = #{hotelId}")
    void update(HotelInfo hotelInfo);
}
