package com.gem.furniture.web;

import com.alibaba.fastjson.JSON;
import com.gem.furniture.entity.Area;
import com.gem.furniture.entity.City;
import com.gem.furniture.entity.Province;
import com.gem.furniture.service.AreaService;
import com.gem.furniture.service.CityService;
import com.gem.furniture.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ssxjl")
public class SsxjlController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    ProvinceService provinceService;
    @Autowired
    AreaService areaService;
    @Autowired
    CityService cityService;

    String jsonStr = null;


    @RequestMapping("/getProvince")
    @ResponseBody
    public String sheng(){
        List<Province> provinces = provinceService.list();
        //把Java对象转换成JSON对象
        //注意:此处需要导入第三方JSON处理Jar包,阿里(fastjson),goole(gson),框架(jackson)
        jsonStr = JSON.toJSONString(provinces);
        return jsonStr;
    }
    @RequestMapping("/getCity")
    @ResponseBody
    public String shi(HttpServletRequest request){
        String code = request.getParameter("code");
        List<City> cities = cityService.selectCitiesByCityCode(code);
        jsonStr = JSON.toJSONString(cities);
        return jsonStr;
    }
    @RequestMapping("/getArea")
    @ResponseBody
    public String xian(HttpServletRequest request){
        String code = request.getParameter("code");
        List<Area> areas = areaService.selectAreasByAreaCode(code);
        jsonStr = JSON.toJSONString(areas);
        return jsonStr;
    }

}
