package com.gem.furniture.service;


import com.gem.furniture.entity.FurRole;
import com.gem.furniture.mapper.FurRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface FurRoleService  {

    FurRole selectById(Long id);
}
