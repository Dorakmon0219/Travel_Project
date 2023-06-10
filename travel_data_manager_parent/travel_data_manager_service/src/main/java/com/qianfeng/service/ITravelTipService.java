package com.qianfeng.service;

import com.qianfeng.domain.TravelTip;

import java.util.List;

public interface ITravelTipService {


    void add(TravelTip travelTip);

    void deleteByIds(String[] ids);

    List<TravelTip> findAll(Integer page, Integer pageSize);

    String updateCountById(String tipId);

    void update(TravelTip travelTip);

    TravelTip findById(String tipId);
}
