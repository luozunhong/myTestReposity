package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.furniture.entity.City;
import com.gem.furniture.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


@Service
public class CityServiceImpl extends ServiceImpl<CityMapper,City> implements CityService {


    @Autowired
    CityMapper cityMapper;


    @Override
    public List<City> selectCitiesByCityCode(String code) {
        return cityMapper.selectCitiesByCityCode(code);
    }
    @Override
    public City selectCityByCode(String code) {
        return cityMapper.selectCityByCode(code);
    }
}
