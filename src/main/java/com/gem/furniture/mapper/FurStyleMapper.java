package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.furniture.entity.FurStyle;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FurStyleMapper extends BaseMapper<FurStyle> {

    @Select("select * from fur_style where style=#{style}")
    List<FurStyle> selectByStyle(String style);

    @Select("select * from fur_style where style=#{style} or sname=#{sname}")
    List<FurStyle> selectByAllStyle(String style,String sname);

}
