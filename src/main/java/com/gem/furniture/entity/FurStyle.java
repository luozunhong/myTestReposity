package com.gem.furniture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("FUR_STYLE")
public class FurStyle {
    @TableId(type = IdType.AUTO)
    private Long sid;
    private String sname;
    private String picture;
    private String design;
    private String style;
    private Long pid;
}
