package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.IOrderDao;
import com.qianfeng.domain.Orders;
import com.qianfeng.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private IOrderDao orderDao;

    @Override
    public List<Orders> findAll(@RequestParam(defaultValue = "1",name = "page") Integer page, @RequestParam(defaultValue = "5",name = "pageSize") Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Orders> ordersList = orderDao.findAll(page, pageSize);
        return ordersList;
    }

    @Override
    public Orders findById(String id) {
        Orders orders = orderDao.findById(id);
        return orders;
    }
}
