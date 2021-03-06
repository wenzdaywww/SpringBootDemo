package com.www.demo.security.impl;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUserEntity;
import com.www.demo.model.mapper.ISysUserRoleMapper;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @version 1.0
 * @Description 用户详细信息服务类，用于实现spring security的登录认证
 * @Author www
 * @Date 2021/6/22 22:35
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysUserRoleMapper sysUserRoleMapper;

    /**
     * @Author www
     * @Date 2021/6/22 22:36
     * @Description 加载用户信息
     * @param userId 用户ID
     * @return org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        LOG.info("-----> security加载{}用户信息",userId);
        SysUserEntity userEntity = sysUserService.findUserAllInfo(userId);
        if (userEntity == null) {
            return null;
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(userEntity.getRoleList())){
            //角色权限必须添加“ROLE_”前缀，否则无法匹配
            userEntity.getRoleList().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName())));
        }
        //密码必须加密，否则无效
        User user = new User(userEntity.getUserId(), new BCryptPasswordEncoder().encode(userEntity.getPassWord()),authorities);
        //获取当前session
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("adminUser",userEntity);
        return user;
    }
}
