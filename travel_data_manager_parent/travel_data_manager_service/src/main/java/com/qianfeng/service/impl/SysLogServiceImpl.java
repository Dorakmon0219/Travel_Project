package com.qianfeng.service.impl;

import com.qianfeng.dao.ISysLogDao;
import com.qianfeng.domain.SysLog;
import com.qianfeng.service.ISysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysLogServiceImpl implements ISysLogService {
    @Resource
    private ISysLogDao sysLogDao;
    @Override
    public void addSysLog(SysLog sysLog) {
        sysLogDao.addSysLog(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        List<SysLog> sysLogs = sysLogDao.findAll();
        return sysLogs;
    }
}
