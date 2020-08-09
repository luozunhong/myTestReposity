package com.gem.furniture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
//用户表

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("FUR_USER")
public class FurUser implements Serializable {
    private static final long serialVersionUID = 1067199959066893268L;
    @TableId(type = IdType.AUTO)
    private Long uid;
    //用户id
    private String head;
    //头像
    private String uname;
    //名字
    private String realName;
    //真实姓名
    private String password;
    //密码
    private String phone;
    //手机
    private Gender Gender;
    //性别
    private String email;
    //邮箱
    private Date birthDate;
    //出生日期
    private String payWord;
    //支付密码
    private String SafeQues;
    //安全问题
    private String SafeAnswer;
    //安全问题答案
    private LocalDateTime LastVisitTime;
    //最后访问时间
    private LocalDateTime RegisterTime;
    //注册时间




}
