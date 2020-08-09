package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.furniture.entity.FurRole;
import com.gem.furniture.mapper.FurRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FurRoleServiceImpl extends ServiceImpl<FurRoleMapper, FurRole> implements FurRoleService {
    @Autowired
    FurRoleMapper furRoleMapper;
    @Override
    public FurRole selectById(Long id) {
        return furRoleMapper.selectById(id);
    }

}
