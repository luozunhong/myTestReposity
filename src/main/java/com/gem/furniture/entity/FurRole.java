package com.gem.furniture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("FUR_ROLE")
public class FurRole implements Serializable {
    private static final long serialVersionUID = -1934025047100587202L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String role;

}
