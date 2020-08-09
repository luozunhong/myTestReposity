package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.furniture.entity.FurUser;
import com.gem.furniture.mapper.FurUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FurUserServiceImpl extends ServiceImpl<FurUserMapper, FurUser> implements FurUserService {

    @Autowired
    private FurUserMapper userMapper;

    @Override
    public FurUser selectById(Long id) {

        return userMapper.selectById(id);
    }

    @Override
    public FurUser selectByName(String uname)
    {
        return userMapper.selectByName(uname);
    }

    @Override
    public FurUser selectByPhone(String phone)
    {
        return userMapper.selectByPhone(phone);
    }
}
