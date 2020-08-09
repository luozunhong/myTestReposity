package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.furniture.entity.FurUserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FurUserRoleMapper extends BaseMapper<FurUserRole> {
    @Select("SELECT * FROM fur_userrole WHERE user_id = #{userId}")
    List<FurUserRole> listByUserId(Long userId);
}
