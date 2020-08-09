package com.gem.furniture.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Data;
import lombok.Getter;

@Getter
public enum Gender {
   MALE(0," 男"),FEMALE(1,"女");


    @EnumValue
    private final int code;
    private final String desc;

    Gender(int code, String desc) {
        this.code=code;
        this.desc=desc;
    }
}
