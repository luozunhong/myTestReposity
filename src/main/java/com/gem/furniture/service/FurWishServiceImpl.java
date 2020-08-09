package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.furniture.entity.FurWish;
import com.gem.furniture.mapper.FurWishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FurWishServiceImpl extends ServiceImpl<FurWishMapper, FurWish> implements FurWishService {
    @Autowired
    FurWishMapper furWishMapper;

    @Override
    public boolean romveByPid(Long pid) {
        return furWishMapper.DeleteByPid(pid);
    }
}
