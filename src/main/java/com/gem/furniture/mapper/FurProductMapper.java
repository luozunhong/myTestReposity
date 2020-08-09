package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.furniture.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FurProductMapper extends BaseMapper<FurProduct> {


    @Select("select * from fur_product where pid=#{pid}")
    FurProduct selectByPid(Long pid);

    @Select("select * from fur_product ${ew.customSqlSegment}")
    IPage<FurProduct> selectAllFurProduct(Page<FurProduct> age, @Param(Constants.WRAPPER) Wrapper<FurProduct> queryWrapper);

    @Select("select * from fur_product where type=#{type}")
    List<FurProduct> selectByType(String type);

    @Select("select * from fur_product where type=#{type} and is_hot=#{is_hot}")
    List<FurProduct> selectHot(String type,@Param("is_hot")int is_hot);

    @Select("select * from fur_product where type=#{type} order by price asc")
    List<FurProduct> selectByPriceA(String type);

    @Select("select * from fur_product where type=#{type} order by price desc")
    List<FurProduct> selectByPriceD(String type);

    @Select("select * from fur_product where type=#{type} and is_new=#{is_new}")
    FurProduct selectOne(String type,@Param("is_new")int is_new);

    @Select("select * from fur_product ${ew.customSqlSegment}")
    IPage<FurProduct> selectByStatus(Page<FurProduct> age, @Param(Constants.WRAPPER) Wrapper<FurProduct> queryWrapper);

    @Delete("delete from fur_product where pid=#{pid}")
    boolean deleteByyId(Long pid);

    @Update("update fur_product set status=0 where pid=#{pid}")
    boolean updateStatus( Long pid);

   /* @Delete("delete from fur_product where pid in #{pids}")
    Boolean deleteAll(List<Integer> pids);*/

    @Select("select * from fur_product where pid=#{pid}" )
    FurProduct selectStatusByIds(Long ids);


    /*----------------------------------------------------------------------------*/


    @Select("select * from fur_product order by rand() limit 0,#{num}")
    List<FurProduct> selectQianShi(int num);


}
