package com.qianfeng.dao;

import com.qianfeng.domain.TravelTip;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITravelTipDao {
    @Select("select * from travel_tips")
    List<TravelTip> findAll();

    @Insert("insert into travel_tips(tipId, address, author, introduction, url, readCount) values (#{tipId},#{address},#{author},#{introduction},#{url},#{readCount})")
    void add(TravelTip travelTip);

    @Delete("delete from travel_tips where tipId = #{id}")
    void deleteById(String id);

    @Update("update travel_tips set readCount = #{i} where tipId = #{tipId}")
    void updateCountByID(@Param("tipId") String tipId, @Param("i") int i);

    @Select("select * from travel_tips where tipId = #{tipId}")
    TravelTip findById(String tipId);

    @Update("update travel_tips set shareTime = #{shareTime},address = #{address},author = #{author},introduction = #{introduction},url = #{url},readCount = #{readCount} where tipId = #{tipId}")
    void update(TravelTip travelTip);
}
