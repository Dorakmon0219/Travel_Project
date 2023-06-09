package com.qianfeng.service;

import com.qianfeng.domain.HotelInfo;

import java.util.List;

public interface IHotelInfoService {



    void save(HotelInfo hotelInfo);

    void deleteIds(String[] ids);

    HotelInfo findById(String id);

    void update(HotelInfo hotelInfo);

    List<HotelInfo> findAll(Integer page, Integer pageSize);
}
