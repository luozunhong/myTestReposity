package com.gem.furniture.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gem.furniture.entity.Dict;
import com.gem.furniture.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 字典工具类
 */
@Component
public class DictUtils {
    @Autowired
    private DictService service;
    private static DictService sysDictService;

    @PostConstruct  //完成对service的注入
    public void init() {
        sysDictService = service;
    }

    /**
     * 获取字段值
     */
    public String getDictValue(String type, Integer code) {
        Dict dict = sysDictService.getOne(new QueryWrapper<Dict>()
                .eq("type", type).eq("code", code));
        return dict.getLabel();
    }

    /**
     * 获取字典value值
     */
    public Integer getCode(String type, String label) {
        //缓存中数据，则db
        Dict dict = sysDictService.getOne(new QueryWrapper<Dict>()
                .eq("type", type).eq("label", label));
        return dict.getCode();
    }

    /**
     * 获取类型
     */
    public List<Dict> getDicList(String type) {
        QueryWrapper qw = new QueryWrapper();
        qw.like("type","product_type");
        return sysDictService.list(qw);
    }


    //获取风格
    public List<Dict> getDicLists(String type) {
        QueryWrapper qw = new QueryWrapper();
        qw.like("type","product_style");
        return sysDictService.list(qw);
    }

}