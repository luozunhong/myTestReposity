package com.gem.furniture.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("FUR_USERROLE")
public class FurUserRole implements Serializable {
    private static final long serialVersionUID = 4233431852403063883L;
    private Long userId;
    private Long roleId;

}
