package com.qianfeng.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.domain.HotelInfo;
import com.qianfeng.domain.Orders;
import com.qianfeng.service.IHotelInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelInfoController {

    @Resource
    private IHotelInfoService hotelInfoService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "1",name = "page") Integer page, @RequestParam(defaultValue = "5",name = "pageSize")Integer pageSize){
        ModelAndView mav = new ModelAndView();
        List<HotelInfo> hotelInfoList = hotelInfoService.findAll(page,pageSize);
        PageInfo<HotelInfo> pageInfo = new PageInfo<>(hotelInfoList);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("hotel-list");
        return mav;
    }
    ////
    @RequestMapping("/save")
    public String save(HotelInfo hotelInfo){
        hotelInfoService.save(hotelInfo);
        return "redirect:/hotel/findAll";
    }

    @RequestMapping("/deleteIds")
    public String deleteIds(String[] ids){
        hotelInfoService.deleteIds(ids);
        return "redirect:/hotel/findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView mav = new ModelAndView();
        HotelInfo hotel = hotelInfoService.findById(id);
        mav.addObject("hotel", hotel);
        mav.setViewName("hotel-update");
        return mav;
    }

    @RequestMapping("/update")
    public String update(HotelInfo hotelInfo){
        hotelInfoService.update(hotelInfo);
        System.out.printf("-----------------------------------??????", hotelInfo);
        return "redirect:/hotel/findAll";
    }
}
