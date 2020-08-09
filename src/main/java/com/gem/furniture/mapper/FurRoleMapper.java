package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.furniture.entity.FurRole;
import org.apache.ibatis.annotations.Select;

public interface FurRoleMapper extends BaseMapper<FurRole> {
    @Select("SELECT * FROM fur_role WHERE id = #{id}")
    FurRole selectById(Long id);
}
