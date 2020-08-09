package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.furniture.entity.FurCart;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FurCartMapper extends BaseMapper<FurCart> {
    @Select("select * from fur_cart where uid=#{uid}")
    List<FurCart> selectByUid(Long uid);

    @Select("select * from fur_cart where cid=#{cid}")
    FurCart selectByCid(Long cid);


    @Select("select * from fur_cart where pid=#{pid}")
    FurCart selectByPid(Long pid);
    @Select("select * from fur_cart where pid=#{pid} and uid=#{uid}")
    List<FurCart> selectByUidPid(Long pid ,Long uid);

    @Select("select * from fur_cart where pid=#{pid} and uid=#{uid}")
    FurCart getByPidUid(Long pid ,Long uid);
}
