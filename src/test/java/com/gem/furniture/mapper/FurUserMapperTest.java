package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.gem.furniture.FurnitureApplicationTests;
import com.gem.furniture.entity.FurUser;
import com.gem.furniture.entity.FurUserRole;
import com.gem.furniture.service.FurUserRoleService;
import com.gem.furniture.service.FurUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class FurUserMapperTest extends FurnitureApplicationTests {
    @Autowired
    private FurUserRoleService userRoleService;
    @Autowired
    private FurUserService userService;
    @Autowired
    FurProductMapper furProductMapper;
    @Test
    public void selectByID(){
//        FurUser furUser=furUserMapper.selectById(1L);
//        System.out.println(furUser);
        //FurUser user = userService.selectByName("admin");
//        List<FurUserRole> userRoles =userRoleService.listByUserId(1L);
//        userRoles.forEach(System.out::println);
 //        furUserMapper.selectOne(Wrappers.<FurUser>query().eq("phone",1001));
 //       new QueryChainWrapper<>(furUserMapper).eq("phone",1001).list().forEach(System.out::println);
            furProductMapper.selectQianShi(5).forEach(System.out::println);

    }

}