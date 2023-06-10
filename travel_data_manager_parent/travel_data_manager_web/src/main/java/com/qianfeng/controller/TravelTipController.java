package com.qianfeng.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.domain.TravelTip;
import com.qianfeng.service.ITravelTipService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/travelTips")
public class TravelTipController {
    @Resource
    private ITravelTipService iTravelTipService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "1", name = "page") Integer page, @RequestParam(defaultValue = "3", name = "pageSize") Integer pageSize){
        List<TravelTip> travelTipList = iTravelTipService.findAll(page, pageSize);
        PageInfo<TravelTip> pageInfo = new PageInfo<>(travelTipList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("travelTips-list");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add(TravelTip travelTip){
        iTravelTipService.add(travelTip);
        return  "redirect:/travelTips/findAll";
    }

    @RequestMapping("/deleteByIds")
    public String deleteByIds(String[] ids){
        iTravelTipService.deleteByIds(ids);
        return "redirect:/travelTips/findAll";

    }

    @RequestMapping("/updateCountById")
    public RedirectView updateCountById(String tipId){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(iTravelTipService.updateCountById(tipId));
        return redirectView;
    }
    @RequestMapping("/update")
    public String update(TravelTip travelTip){
        iTravelTipService.update(travelTip);
        return "redirect:/travelTips/findAll";
    }
    @RequestMapping("/findById")
    public ModelAndView findById(String tipId){
        TravelTip travelTip =iTravelTipService.findById(tipId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("travelTips",travelTip);
        modelAndView.setViewName("travelTips-update");
        return  modelAndView;
    }
}
