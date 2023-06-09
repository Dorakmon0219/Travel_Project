package com.qianfeng.dao;

import com.qianfeng.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IRoleDao {

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(id, roleName, roleDesc) values(#{id},#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results(id = "baseResult", value = {
            @Result(id = true,  column = "id", property = "id"),
            @Result(column = "email", property = "email"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(property = "permissions", column = "id", many = @Many(select = "com.qianfeng.dao.IPermissionDao.findByRoleId", fetchType = FetchType.LAZY))
    })
    List<Role> findByUserId(String userId);

    @Select("select * from role where id not in (select roleId from users_role where userId = #{id})")
    List<Role> findUserByIdAndAllRole(String id);
}
