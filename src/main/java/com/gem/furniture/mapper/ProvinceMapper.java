package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.furniture.entity.Area;
import com.gem.furniture.entity.Province;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProvinceMapper extends BaseMapper<Province> {


    @Select("select * from province where code=#{code}")
    Province selectByCode(String code);

}
