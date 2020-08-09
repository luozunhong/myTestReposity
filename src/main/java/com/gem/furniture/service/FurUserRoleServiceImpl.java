package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.furniture.entity.FurUserRole;
import com.gem.furniture.mapper.FurUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurUserRoleServiceImpl extends ServiceImpl<FurUserRoleMapper, FurUserRole> implements FurUserRoleService {

    @Autowired
    private FurUserRoleMapper userRoleMapper;

    @Override
    public List<FurUserRole> listByUserId(Long userId) {

        return userRoleMapper.listByUserId(userId);
    }
}
