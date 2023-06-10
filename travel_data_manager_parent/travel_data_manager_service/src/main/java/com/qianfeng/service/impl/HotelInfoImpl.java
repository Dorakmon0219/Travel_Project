package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.IHotelInfoDao;
import com.qianfeng.dao.IPermissionDao;
import com.qianfeng.domain.HotelInfo;
import com.qianfeng.domain.Product;
import com.qianfeng.service.IHotelInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HotelInfoImpl implements IHotelInfoService {
    @Resource
    private IHotelInfoDao hotelInfoDao;



    @Override
    public void save(HotelInfo hotelInfo) {
        hotelInfoDao.save(hotelInfo);
    }

    @Override
    public void deleteIds(String[] ids) {
        for (String id : ids) {
            hotelInfoDao.deleteId(id);
        }
    }

    @Override
    public HotelInfo findById(String id) {
        HotelInfo hotel = hotelInfoDao.finById(id);
        return hotel;
    }

    @Override
    public void update(HotelInfo hotelInfo) {
        hotelInfoDao.update(hotelInfo);
    }

    @Override
    public List<HotelInfo> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);//导包，帮助我们在sql上拼接limit语句
        List<HotelInfo> hotelInfoList = hotelInfoDao.findAll();
        return hotelInfoList;
    }
}
