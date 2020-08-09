package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gem.furniture.entity.FurCart;

import java.util.List;

public interface FurCartService extends IService<FurCart> {


    FurCart getByPid(Long pid);
}
