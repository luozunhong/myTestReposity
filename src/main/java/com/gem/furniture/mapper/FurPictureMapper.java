package com.gem.furniture.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.furniture.entity.*;
import org.apache.ibatis.annotations.Select;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import java.util.List;

public interface FurPictureMapper extends BaseMapper<FurPicture> {
       @Select("select * from fur_picture where pid=#{pid}")
       List<FurPicture> selectByPid(Long pid);

       @Select("select * from fur_evaluate where pid=#{pid}")
       List<FurEvaluate> selectOrderByPid(Long pid);
}
