package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.furniture.entity.FurWish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface FurWishMapper extends BaseMapper<FurWish> {

    @Select("select * from fur_wish where uid=#{uid}")
    List<FurWish> selectByUid(Long uid);

    @Delete("delete from fur_wish where pid=#{pid}")
    boolean DeleteByPid(Long pid);

    @Select("select * from fur_wish where uid=#{uid} and pid=#{pid}")
    List<FurWish> selectByUidPid(Long uid ,Long pid);


    @Delete("delete from fur_wish where pid=#{pid} and uid=#{uid}")
    boolean DeleteByUid(Long pid,Long uid);

}
