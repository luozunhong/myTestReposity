package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.furniture.entity.FurUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FurUserMapper extends BaseMapper<FurUser> {
    @Select("SELECT * FROM fur_user WHERE uid = #{uid}")
    FurUser selectById(Long uid);

    @Select("SELECT * FROM fur_user WHERE uname = #{name}")
    FurUser selectByName(String name);

    @Select("SELECT * FROM fur_user WHERE phone = #{phone}")
    FurUser selectByPhone(String phone);

}
