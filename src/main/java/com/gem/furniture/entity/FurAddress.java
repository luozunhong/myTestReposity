package com.gem.furniture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
//收货地址表
@Data
@TableName("FUR_ADDRESS")
public class FurAddress implements Serializable {
    private static final long serialVersionUID = -159214987088930087L;
    @TableId(type= IdType.AUTO)
    private Long shipId;
    //收获信息id
    private Long uid;
    //用户id
    private Integer IsDefault;
    //是否为默认地址
    private String Consignee;
    //收货人
    private String phone;
    //手机号
    private String province;
    //省
    private String city;
    //市
    private String area;
    //县
    private String address;
    //详细地址





}
