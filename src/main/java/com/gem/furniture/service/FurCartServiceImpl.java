package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.furniture.entity.FurCart;
import com.gem.furniture.mapper.FurCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FurCartServiceImpl extends ServiceImpl<FurCartMapper, FurCart> implements FurCartService {

    @Autowired
    private FurCartMapper furCartMapper;

    @Override
    public FurCart getByPid(Long pid) {
        return furCartMapper.selectByPid(pid);
    }
}
