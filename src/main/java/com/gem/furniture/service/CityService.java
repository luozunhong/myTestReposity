package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gem.furniture.entity.City;

import java.util.List;

public interface CityService extends IService<City> {

    List<City> selectCitiesByCityCode(String code);

    City selectCityByCode(String code);
}
