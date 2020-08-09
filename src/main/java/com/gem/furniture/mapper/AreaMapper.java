package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.furniture.entity.Area;
import com.gem.furniture.entity.City;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AreaMapper extends BaseMapper<Area> {

    @Select("select * from area where city_id = #{code}")
    List<Area> selectAreasByAreaCode(String code);

    @Select("select * from area where code=#{code}")
    Area selectAreaByCode(String code);
}
