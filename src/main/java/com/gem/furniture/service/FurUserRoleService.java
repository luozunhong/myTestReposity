package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gem.furniture.entity.FurUserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FurUserRoleService extends IService<FurUserRole> {


    List<FurUserRole> listByUserId(Long uid);
}
