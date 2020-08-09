package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gem.furniture.entity.FurUser;
import com.gem.furniture.mapper.FurUserMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

public interface FurUserService extends IService<FurUser> {


    FurUser selectById(Long id);


    FurUser selectByName(String uname);

    FurUser selectByPhone(String phone);


}
