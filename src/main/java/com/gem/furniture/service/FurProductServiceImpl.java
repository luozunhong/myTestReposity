package com.gem.furniture.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.furniture.entity.*;
import com.gem.furniture.mapper.FurProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
@Service
public class FurProductServiceImpl extends ServiceImpl<FurProductMapper,FurProduct> implements FurProductService {

    @Autowired
    FurProductMapper furProductMapper;


}
