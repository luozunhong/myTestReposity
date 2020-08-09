package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.furniture.entity.FurEvaluate;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FurEvaluateMapper extends BaseMapper<FurEvaluate> {

    @Select("select * from fur_evaluate where uid = #{uid}")
    List<FurEvaluate> selectEvaluateById(Long uid);
}
