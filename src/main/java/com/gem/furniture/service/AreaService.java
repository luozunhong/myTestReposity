package com.gem.furniture.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gem.furniture.entity.Area;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AreaService extends IService<Area> {

    List<Area> selectAreasByAreaCode(String code);
    Area selectAreaByCode(String code);
}
