package com.qianfeng.dao;

import com.qianfeng.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISysLogDao {
    @Insert("insert into syslog(id,username,ip,url,method,visitTime,executionTime) values(#{id},#{username},#{ip},#{url},#{method},#{visitTime},#{executionTime})")
    void addSysLog(SysLog sysLog);

    @Select("select * from syslog")
    List<SysLog> findAll();
}
