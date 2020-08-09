package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.furniture.entity.FurAddress;
import com.gem.furniture.mapper.FurAddressMapper;
import org.springframework.stereotype.Service;

@Service
public class FurAddressServiceImpl extends ServiceImpl<FurAddressMapper, FurAddress> implements FurAddressService {

}
