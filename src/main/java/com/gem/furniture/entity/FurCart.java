package com.gem.furniture.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

//购物车表
@TableName("fur_cart")
@Data
public class FurCart implements Serializable {
    private static final long serialVersionUID = 5159151719481523875L;
    @TableId(type= IdType.AUTO)
    private Long cid;
    //购物车id
    private Long uid;
    //用户id
    private Long pid;
    //商品id
    private String pname;
    //商品名字
    private Double price;
    //商品价格
    private String picture;
    //商品图片
    private int count;
    //商品数量
    private Double total;
    //商品总价

}
