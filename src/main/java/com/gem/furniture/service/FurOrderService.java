package com.gem.furniture.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gem.furniture.entity.FurOrder;

import java.util.List;

public interface FurOrderService extends IService<FurOrder> {


    Long findUidById(Long oid);
    List<FurOrder> findNoById(Long uid);
    IPage<FurOrder> selectAllFurOrder(Page<FurOrder> age , Wrapper<FurOrder> queryWrapper);
    IPage<FurOrder> findByTimes(Page<FurOrder> age , Wrapper<FurOrder> queryWrapper);
    /* List<FurOrder> findByOrderStatus(int cateId);*/
    FurOrder findOrderByNo(String no);
    IPage<FurOrder> findByOrderStatus(Page<FurOrder> age , Wrapper<FurOrder> queryWrapper);
    IPage<FurOrder> findOrderByName(Page<FurOrder> age , Wrapper<FurOrder> queryWrapper);

}
