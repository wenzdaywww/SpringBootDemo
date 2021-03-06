package com.www.demo.model.mapper;

import com.www.demo.model.entity.SysRoleEntity;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @Description SysRoleMapper接口
 * @Author www
 * @Date 2021/5/19 23:36
 */
public interface ISysRoleMapper {
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 根据主键ID删除角色信息
     *
     * @param id 主键ID
     * @return int 删除条数
     */
    int deleteByPrimaryKey(BigDecimal id);
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 插入角色信息
     *
     * @param record 角色信息
     * @return int 插入条数
     */
    int insert(SysRoleEntity record);
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 插入角色信息（插入非空数据）
     *
     * @param record 角色信息
     * @return int 插入条数
     */
    int insertSelective(SysRoleEntity record);
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 根据主键ID查询角色信息
     *
     * @param id 主键ID
     * @return com.www.demo.model.SysRoleEntity 角色信息
     */
    SysRoleEntity selectByPrimaryKey(BigDecimal id);
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 更新角色信息（更新非空数据）
     *
     * @param record 角色信息
     * @return int 更新条数
     */
    int updateByPrimaryKeySelective(SysRoleEntity record);
    /**
     * @Author www
     * @Date 2021/5/19 23:48
     * @Description 更新角色信息
     *
     * @param record 角色信息
     * @return int 更新条数
     */
    int updateByPrimaryKey(SysRoleEntity record);
}