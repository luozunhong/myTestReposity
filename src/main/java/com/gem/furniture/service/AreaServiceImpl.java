package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.furniture.entity.Area;
import com.gem.furniture.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper,Area> implements AreaService {


    @Autowired
    AreaMapper areaMapper;

    @Override
    public List<Area> selectAreasByAreaCode(String code) {
        return areaMapper.selectAreasByAreaCode(code);
    }
    @Override
    public Area selectAreaByCode(String code) {
        return areaMapper.selectAreaByCode(code);
    }
}
