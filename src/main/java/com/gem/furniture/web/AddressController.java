package com.gem.furniture.web;


import com.gem.furniture.entity.*;
import com.gem.furniture.mapper.FurAddressMapper;
import com.gem.furniture.mapper.FurOrderMapper;
import com.gem.furniture.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class AddressController {
    @Autowired
    FurAddressService furAddressService;
    @Autowired
    AreaService areaService;
    @Autowired
    CityService cityService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    FurAddressMapper furAddressMapper;
    @Autowired
    FurOrderMapper furOrderMapper;
    @Autowired
    FurOrderService furOrderService;

    //删除订单
    @DeleteMapping("/ddsc")
    @ResponseBody
    public String shanchudd(Long pid,HttpSession session){
        System.out.println(pid);
        FurUser furUser = (FurUser) session.getAttribute("user");
        furOrderMapper.deleteUidById(pid,furUser.getUid());
        return "删除成功";
    }
    //确认收货
    @PostMapping("/qrsh")
    @ResponseBody
    public String querenshouhuo( Long pid,HttpSession session){
        FurUser furUser = (FurUser) session.getAttribute("user");
        FurOrder furOrder = furOrderMapper.selectFurOrderByPid(pid,furUser.getUid());
        furOrder.setCateId(4);
        furOrderService.updateById(furOrder);
        return "收货成功";
    }

    @PostMapping("/addres")
    @ResponseBody
    public String addres1(FurAddress furAddress, HttpSession session){
        FurUser user = (FurUser)session.getAttribute("user");
        Province province = provinceService.selectByCode(furAddress.getProvince());
        furAddress.setProvince(province.getName());
        City city = cityService.selectCityByCode(furAddress.getCity());
        furAddress.setCity(city.getName());
        Area area = areaService.selectAreaByCode(furAddress.getArea());
        furAddress.setArea(area.getName());
        furAddress.setUid(user.getUid());
        furAddressService.save(furAddress);
        return "新增成功";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        FurAddress furAddress1 = furAddressMapper.selectByshipIp(id);
        model.addAttribute("isdefault",furAddress1);
        return "addressadd";
    }
    @RequestMapping("edit/add")
    @ResponseBody
    public String edits(FurAddress furAddress, HttpSession session){
        FurUser user = (FurUser)session.getAttribute("user");
        Province province = provinceService.selectByCode(furAddress.getProvince());
        if(null==province){
            furAddress.setProvince(furAddress.getProvince());
        }else {
            furAddress.setProvince(province.getName());
        }
        City city = cityService.selectCityByCode(furAddress.getCity());
        if(null==city){
            furAddress.setCity(furAddress.getProvince());
        }else{

            furAddress.setCity(city.getName());
        }
        Area area = areaService.selectAreaByCode(furAddress.getArea());
        if(null==area){
            furAddress.setArea(furAddress.getArea());
        }else{
            furAddress.setArea(area.getName());
        }
        furAddress.setUid(user.getUid());
        Boolean b = furAddressService.updateById(furAddress);
        return b?"修改成功":"修改失败";
    }
    @RequestMapping("/moren")
    @ResponseBody
    public String moren(Long id, HttpSession session){
        FurUser user= (FurUser) session.getAttribute("user");
        FurAddress furAddress = furAddressMapper.selectByIsdefault(1,user.getUid());
        if(null!=furAddress){
            furAddress.setIsDefault(0);
            furAddressService.updateById(furAddress);
        }
        FurAddress furAddress1 = furAddressMapper.selectByshipIp(id);
        furAddress1.setIsDefault(1);
        furAddressService.updateById(furAddress1);
        return "设置成功";
    }
    @RequestMapping("/shanchu")
    @ResponseBody
    public String shanchu(Long id){
        furAddressService.removeById(id);
        return "删除成功";
    }
}
