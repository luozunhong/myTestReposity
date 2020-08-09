package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gem.furniture.entity.FurWish;

public interface FurWishService extends IService<FurWish> {
    boolean romveByPid(Long pid);
}
