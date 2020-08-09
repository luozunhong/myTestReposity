package com.gem.furniture.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
//商品表
@Data
@TableName("FUR_PRODUCT")
public class FurProduct implements Serializable {
    private static final long serialVersionUID = 6512217167515963601L;
   @TableId(type = IdType.AUTO)
   private Long pid;//商品id
 private String pname;//商品名字
 private Double price;//价格
 private Double originalPrice;//原价
 private String introduction;//商品简介
 private String type;//商品类别
 private String isHot;//是否热销
 private String isNew;//是否是新品
 private Long inventory;//库存
 //private String details;//详情
 private String picture;//商品图片
 @TableLogic
 private Integer status;//商品状态(上架下架)
 private Long cateId;
 private String description;
 private Integer xingji;

}
