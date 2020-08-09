package com.gem.furniture.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.furniture.entity.FurOrder;
import com.gem.furniture.mapper.FurOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FurOrderServiceImpl extends ServiceImpl<FurOrderMapper, FurOrder> implements FurOrderService {
    @Autowired
    private FurOrderMapper orderMapper;
    @Autowired
    private FurOrderService orderService;
    @Override
    public Long findUidById(Long oid) {

        return orderMapper.selectUidById(oid);
    }

    @Override
    public IPage<FurOrder> selectAllFurOrder(Page<FurOrder> age, Wrapper<FurOrder> queryWrapper) {
        return orderMapper.selectAllFurOrder(age,queryWrapper);
    }

    @Override
    public IPage<FurOrder> findByTimes(Page<FurOrder> age, Wrapper<FurOrder> queryWrapper) {

        return orderMapper.selectByTimes(age,queryWrapper);
    }

    /*@Override
    public List<FurOrder> findByOrderStatus(int cateId) {
        return orderMapper.selectByOrderStatus(cateId);
    }
*/
    @Override
    public FurOrder findOrderByNo(String no) {
        return orderMapper.selectOrderByNo(no);
    }

    @Override
    public IPage<FurOrder> findByOrderStatus(Page<FurOrder> age, Wrapper<FurOrder> queryWrapper) {
        return orderMapper.selectByOrderStatus(age,queryWrapper);
    }


    @Override
    public List<FurOrder> findNoById(Long uid) {
        return orderMapper.selectNoById(uid);
    }
    @Override
    public IPage<FurOrder> findOrderByName(Page<FurOrder> age, Wrapper<FurOrder> queryWrapper) {
        return orderMapper.selectOrderByName(age,queryWrapper);
    }
}
