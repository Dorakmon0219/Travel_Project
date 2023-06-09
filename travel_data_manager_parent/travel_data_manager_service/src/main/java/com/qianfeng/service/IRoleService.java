package com.qianfeng.service;

import com.qianfeng.domain.Role;
import com.qianfeng.domain.UserInfo;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();

    void save(Role role);

    List<Role> findUserByIdAndAllRole(String id);
}
