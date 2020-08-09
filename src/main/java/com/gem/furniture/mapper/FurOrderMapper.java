package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.furniture.entity.FurOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FurOrderMapper extends BaseMapper<FurOrder> {



    @Select("SELECT uid FROM fur_order WHERE oid = #{id}")
    Long selectUidById(Long oid);
    //删除订单
    @Select("delete FROM fur_order WHERE pid = #{pid} and uid=#{uid}")
    void deleteUidById(Long pid,Long uid);
    //确认收货
    @Select("SELECT * FROM fur_order WHERE pid = #{pid} and uid=#{uid}")
    FurOrder selectFurOrderByPid(Long pid,Long uid);
    //查询所有订单uid
    @Select("SELECT * FROM fur_order WHERE uid = #{uid}")
    List<FurOrder> selectNoById(Long uid);
    @Select("select * from fur_order ${ew.customSqlSegment}")
    IPage<FurOrder> selectAllFurOrder(Page<FurOrder> age, @Param(Constants.WRAPPER) Wrapper<FurOrder> queryWrapper);
    @Select("SELECT * FROM fur_order ${ew.customSqlSegment}")
    IPage<FurOrder> selectByTimes(Page<FurOrder> age, @Param(Constants.WRAPPER) Wrapper<FurOrder> queryWrapper);
    /*   @Select("SELECT * FROM fur_order WHERE cate_id=#{cateId}")
        List<FurOrder> selectByOrderStatus1(int cateId);*/
    @Select("SELECT * FROM fur_order WHERE no = #{no}")
    FurOrder selectOrderByNo(String no);
    @Select("SELECT * FROM fur_order ${ew.customSqlSegment}")
    IPage<FurOrder> selectByOrderStatus(Page<FurOrder> age, @Param(Constants.WRAPPER) Wrapper<FurOrder> queryWrapper);

    @Select("SELECT * FROM fur_order WHERE cate_id=#{cate} and uid=#{uid}")
    List<FurOrder> selectOrdersByCate(int cate,Long uid);
    @Select("SELECT * FROM fur_order ${ew.customSqlSegment}")
    IPage<FurOrder> selectOrderByName(Page<FurOrder> age, @Param(Constants.WRAPPER) Wrapper<FurOrder> queryWrapper);



    @Update("update fur_order set cate_id=2 where no=#{no}")
    void updateCateId( String no);

  /*  //删除订单
    @Select("delete FROM fur_order WHERE pid = #{pid} and uid=#{uid}")
    void deleteUidById(Long pid,Long uid);
    //确认收货
    @Select("SELECT * FROM fur_order WHERE pid = #{pid} and uid=#{uid}")
    FurOrder selectFurOrderByPid(Long pid,Long uid);
    //查询所有订单uid
    @Select("SELECT * FROM fur_order WHERE uid = #{uid}")
    List<FurOrder> selectNoById(Long uid);


    @Select("SELECT uid FROM fur_order WHERE oid = #{id}")
    Long selectUidById(Long oid);
    @Select("select * from fur_order ${ew.customSqlSegment}")
    IPage<FurOrder> selectAllFurOrder(Page<FurOrder> age, @Param(Constants.WRAPPER) Wrapper<FurOrder> queryWrapper);
    @Select("SELECT * FROM fur_order ${ew.customSqlSegment}")
    IPage<FurOrder> selectByTimes(Page<FurOrder> age, @Param(Constants.WRAPPER) Wrapper<FurOrder> queryWrapper);
    *//*   @Select("SELECT * FROM fur_order WHERE cate_id=#{cateId}")
        List<FurOrder> selectByOrderStatus1(int cateId);*//*
    @Select("SELECT * FROM fur_order WHERE no = #{no}")
    FurOrder selectOrderByNo(String no);
    @Select("SELECT * FROM fur_order ${ew.customSqlSegment}")
    IPage<FurOrder> selectByOrderStatus(Page<FurOrder> age, @Param(Constants.WRAPPER) Wrapper<FurOrder> queryWrapper);

    @Select("SELECT * FROM fur_order WHERE cate_id=#{cate}")
    List<FurOrder> selectOrdersByCate(int cate);*/
}
