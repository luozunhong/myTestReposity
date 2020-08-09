package com.gem.furniture.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("FUR_PICTURE")
public class FurPicture implements Serializable {
    private static final long serialVersionUID = -7003935066336771177L;

    @TableId(type = IdType.AUTO)
    private Long id;//图片id
    private Long pid;//商品id
    private String picname;//照片名称


}
