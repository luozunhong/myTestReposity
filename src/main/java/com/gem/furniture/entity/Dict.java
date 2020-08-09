package com.gem.furniture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

//字典表对应的实体
@Data
@TableName("FUR_DICT")
public class Dict implements Serializable {
    private static final long serialVersionUID = 7289668043638268082L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String type;
    private Integer code;
    private String label;
    private String description;
}
