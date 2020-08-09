package com.gem.furniture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
//订单表
@Data
@TableName("FUR_ORDER")
public class FurOrder implements Serializable {
    private static final long serialVersionUID = -7003935066336771177L;
    @TableId(type = IdType.AUTO)
    private  Long oid;
    private String no;//订单编号
    private Long uid;//用户id
    private Long pid;//商品id
    //private String name;//收货人
    private Double price;//价格
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;//购买时间
    private int count;//购买数量
    private Integer cateId;//订单状态(上架下架)
    private String uname;//用户名字
    private String address;
    private String phone;
    private String pname;
    private double total;
    private String picture;


}
