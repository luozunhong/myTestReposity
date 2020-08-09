package com.gem.furniture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("FUR_WISH")
//愿望清单表
public class FurWish implements Serializable {
    private static final long serialVersionUID = 5521978156598750665L;
    @TableId(type= IdType.AUTO)
    private Long wid;//愿望清单id
    private Long uid;//用户id
    private Long pid;//商品id
    private String picture;
    private String pname;
    private Double price;
}
