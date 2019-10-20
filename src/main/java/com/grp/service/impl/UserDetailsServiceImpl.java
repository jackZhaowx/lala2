package com.grp.service.impl;

import com.grp.mybatis.SysUserRoleMapper;
import com.grp.mybatis.entity.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2019/10/20 0020.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserRole sysUserRole = sysUserRoleMapper.getEntityByUsername(username);
        if (sysUserRole != null) {
            Collection<GrantedAuthority> adminAuth = new ArrayList<>();
            List<String> role_ids = sysUserRole.getRole_ids();
            if (role_ids != null && role_ids.size() > 0) {
                for (String role_id : role_ids) {
                    adminAuth.add(new SimpleGrantedAuthority(role_id));
                }
            }
            User user = new User(sysUserRole.getUsername(), sysUserRole.getPassword(), adminAuth);
            return user;
        }
        return null;
    }
}
