package com.qianfeng.service.impl;

import com.qianfeng.dao.IPermissionDao;
import com.qianfeng.domain.Permission;
import com.qianfeng.service.IPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class PermissionServiceImpl implements IPermissionService {
    @Resource
    private IPermissionDao permissionDao;
    @Override
    public List<Permission> findAll() {
        List<Permission> permissionlist = permissionDao.findAll();
        return permissionlist;
    }

    @Override
    public void save(Permission permission) {
        permission.setId(UUID.randomUUID().toString());
        permissionDao.save(permission);
    }
}
