package com.qianfeng.controller;

import com.qianfeng.domain.Permission;
import com.qianfeng.domain.Role;
import com.qianfeng.service.IPermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/permission")
@Controller
public class  PermissionController {
    @Resource
    private IPermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mav = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mav.addObject("permissionList",permissionList);
        mav.setViewName("permission-list");
        return mav;
    }

    @RequestMapping("/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:/permission/findAll";
    }
}
