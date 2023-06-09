package com.qianfeng.service.impl;

import com.qianfeng.dao.IRoleDao;
import com.qianfeng.domain.Role;
import com.qianfeng.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements IRoleService {

    @Resource
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) {
        role.setId(UUID.randomUUID().toString());
        roleDao.save(role);
    }

    @Override
    public List<Role> findUserByIdAndAllRole(String id) {
        return roleDao.findUserByIdAndAllRole(id);
    }
}
