package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.furniture.entity.City;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CityMapper extends BaseMapper<City> {


    @Select("select * from city where province_id = #{code}")
    List<City> selectCitiesByCityCode(String code);


    @Select("select * from city where code = #{code}")
    City selectCityByCode(String code);
}
