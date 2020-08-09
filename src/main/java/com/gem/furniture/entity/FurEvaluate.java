package com.gem.furniture.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

//商品评论表
@Data
@TableName("FUR_EVALUATE")
@NoArgsConstructor
public class FurEvaluate implements Serializable {
    private static final long serialVersionUID = 4755374197946434667L;
    @TableId(type = IdType.AUTO)
    private Long eid;//商品评价id
    private Long uid;//用户id
    private Long pid;//商品id
    private String pname;//商品名字
    private Date dateTime;//评论时间
    private String grade;//等级
    private String comment ;//描述
    private String isImage;//是否带图片
    private Long eCount;//评论数量
    private String uname;
    @TableField(exist = false)
    private String errno;
    @TableField(exist = false)
    private List<String> data;
    public FurEvaluate(String errno, List<String> data) {
        this.errno = errno;
        this.data = data;
    }

    public FurEvaluate(String errno, String data) {
        this.errno = errno;
        this.data = new ArrayList<>();
        this.data.add(data);
    }

}


