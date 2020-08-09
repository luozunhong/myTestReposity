package com.gem.furniture.web;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gem.furniture.entity.*;
import com.gem.furniture.mapper.FurProductMapper;
import com.gem.furniture.mapper.FurUserMapper;
import com.gem.furniture.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BeginController {


    @Autowired
    private FurUserService userService;

    @Autowired
    private FurRoleService roleService;

    @Autowired
    private FurUserRoleService userRoleService;

    @GetMapping("/gem/role")
    @ResponseBody
    public String role(HttpSession session){
        FurUser user=  (FurUser) session.getAttribute("user");

        // 判断用户是否存在
        if (user == null) {
            return "-1";
        }

        // 添加权限
        List<FurUserRole> userRoles =userRoleService.listByUserId(user.getUid());
        for (FurUserRole userRole : userRoles) {
            if(userRole.getRoleId()==1){
                session.setAttribute("role","0");
                return "0";
            }
        }
        session.setAttribute("role","1");
        return "1";
    }




}
