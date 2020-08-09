package com.gem.furniture.service;

import com.gem.furniture.entity.FurRole;
import com.gem.furniture.entity.FurUser;
import com.gem.furniture.entity.FurUserRole;


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
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private FurUserService userService;

    @Autowired
    private FurRoleService roleService;

    @Autowired
    private FurUserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        FurUser user = userService.selectByPhone(username);

        // 判断用户是否存在
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 添加权限
        List<FurUserRole> userRoles =userRoleService.listByUserId(user.getUid());
        for (FurUserRole userRole : userRoles) {
            FurRole role = roleService.selectById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }


        // 返回UserDetails实现类
        return new User(user.getUname(), user.getPassword(), authorities);
        //return new User(user.getUname(), user.getPasssword());
    }
}