package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gem.furniture.entity.Province;

public interface ProvinceService extends IService<Province> {

    Province selectByCode(String code);
}
