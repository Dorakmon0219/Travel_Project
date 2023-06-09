package com.qianfeng.service.impl;

import com.qianfeng.dao.IUserInfoDao;
import com.qianfeng.domain.Role;
import com.qianfeng.domain.UserInfo;
import com.qianfeng.service.IUserInfoService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service(value = "userService")
public class UserInfoImpl implements IUserInfoService {
    @Resource
    private IUserInfoDao userInfoDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDao.findByUsername(username);
        if(userInfo == null){
            return null;
        }
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,getGrantedAuthority(userInfo.getRoles()));
        return user;
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthority(List<Role> roles) {
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> userList = userInfoDao.findAll();
        return userList;
    }

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void save(UserInfo userInfo) {
        userInfo.setId(UUID.randomUUID().toString());
        userInfo.setStatus(1);
        String password = bCryptPasswordEncoder.encode(userInfo.getPassword());
        userInfo.setPASSWORD(password);
        userInfoDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        UserInfo user = userInfoDao.finById(id);
        return user;
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String id : ids) {
            userInfoDao.addRoleToUser(userId, id);
        }
    }
}
