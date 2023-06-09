package com.qianfeng.controller;

import com.qianfeng.domain.Role;
import com.qianfeng.domain.UserInfo;
import com.qianfeng.service.IRoleService;
import com.qianfeng.service.IUserInfoService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserInfoController {
    @Resource
    private IUserInfoService userInfoService;

    @Resource
    private IRoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<UserInfo> userList = userInfoService.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("userList",userList);
        mav.setViewName("user-list");
        return mav;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userInfoService.save(userInfo);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView mav = new ModelAndView();
        UserInfo user = userInfoService.findById(id);
        mav.addObject("user", user);
        mav.setViewName("user-show");
        return mav;
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id){
        ModelAndView mav = new ModelAndView();
        List<Role> roleList = roleService.findUserByIdAndAllRole(id);
        UserInfo user = userInfoService.findById(id);
        mav.addObject("user", user);
        mav.addObject("roleList", roleList);
        mav.setViewName("user-role-add");
        return mav;
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId, String[] ids){
        userInfoService.addRoleToUser(userId, ids);
        return "redirect:/user/findAll";
    }
}
