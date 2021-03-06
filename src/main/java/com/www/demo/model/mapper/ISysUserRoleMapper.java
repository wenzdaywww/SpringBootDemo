package com.www.demo.model.mapper;

import com.www.demo.model.entity.SysRoleEntity;
import com.www.demo.model.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 1.0
 * @Description SysUserRoleMapper接口
 * @Author www
 * @Date 2021/5/19 23:39
 */
public interface ISysUserRoleMapper {
    /**
     * @Author www
     * @Date 2021/6/22 22:00
     * @Description 根据用户ID查询用户拥有角色
     * @param userId 用户ID
     * @return java.util.List<com.www.demo.model.entity.SysRoleEntity> 角色集合
     */
    List<SysRoleEntity> findUserRoles(@Param("userId") String userId);
    /**
     * @Author www
     * @Date 2021/5/19 23:42
     * @Description 插入用户角色信息
     *
     * @param record 用户角色信息
     * @return int 插入条数
     */
    int insert(SysUserRoleEntity record);
    /**
     * @Author www
     * @Date 2021/5/19 23:42
     * @Description 插入用户角色信息（插入非空数据）
     *
     * @param record 用户角色信息
     * @return int 插入条数
     */
    int insertSelective(SysUserRoleEntity record);

    /**
     * @Author www
     * @Date 2021/6/15 23:20
     * @Description 查询用户的角色信息
     *
     * @param record 查询条件
     * @return java.util.List<com.www.demo.model.entity.SysUserRoleEntity>
     */
    List<SysUserRoleEntity> selective(SysUserRoleEntity record);
}