package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.furniture.entity.FurAddress;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FurAddressMapper extends BaseMapper<FurAddress> {


    @Select("select * from fur_address where uid = #{uid}")
    List<FurAddress> selectByUid(Long uid);

    @Select("select * from fur_address where Is_default = #{isdefault} and uid=#{uid}")
    FurAddress selectByIsdefault(Integer isdefault,long uid);

    @Select("select * from fur_address where ship_id = #{shipId}")
    FurAddress selectByshipIp(Long shipId);

    @Select({"select * from fur_address where Is_default = #{isdefault} and  uid = #{uid} "})
    List<FurAddress> selectByIsdefaul(Integer isdefault,long uid);
}
