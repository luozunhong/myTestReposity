package com.gem.furniture.web;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.gem.furniture.entity.*;
import com.gem.furniture.mapper.*;
import com.gem.furniture.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/gem")
public class HomeController {
    @Autowired
    FurProductMapper furProductMapper;

    @Autowired
    FurProductService furProductService;

    @Autowired
    FurStyleMapper furStyleMapper;

    @Autowired
    FurUserService furUserService;
    @Autowired
    FurUserMapper furUserMapper;
    @Autowired
    FurOrderService furOrderService;


    @Autowired
    FurPictureService furPictureService;

    @Autowired
    FurPictureMapper furPictureMapper;

    @Autowired
    FurCartService furCartService;


    @Autowired
    FurCartMapper furCartMapper;

    @Autowired
    FurWishService furWishService;

    @Autowired
    FurWishMapper furWishMapper;

    @Autowired
    FurAddressMapper furAddressMapper;






    //  手机短信验证
   /* @PostMapping("/log")
    @ResponseBody
    public String register(FurUser user, String verify, HttpSession session) {
        System.out.println(session.getAttribute("verifys"));
        String ver = session.getAttribute("verifys")+"";
        if(ver.equals(verify)){
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String pas = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(pas);
            furUserService.save(user);
            return "1";
        }else{
            return "0";
        }
    }*/

    //注册手机是否重复验证
  /*  @PostMapping("/check")
    @ResponseBody
    public String check(String phone) {
        if(phone.length()==11){
            FurUser user= furUserMapper.selectOne(Wrappers.<FurUser>query().eq("phone",phone));
            return user==null ? "0":"1";
        }else if(phone.length()==0){
            return "2";
        }
        return "3";
    }*/



    @GetMapping("/homepage1")
    public String list(Model model) {
        List<FurProduct> furProduct = new QueryChainWrapper<>(furProductMapper)
                .in("pid", 1, 2, 3)
                .list();
        model.addAttribute("furProduct", furProduct);
        return "homepage1";
    }

















    /*-------------------------------------------------*/
    //主页

    @RequestMapping("/home")
    public String Home(Model model, HttpSession session ) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        FurUser user=furUserService.selectByName(name);
        session.setAttribute("user",user);
        model.addAttribute("furProduct",furProductService.getById(1));
        model.addAttribute("product",furProductMapper.selectQianShi(3));
        model.addAttribute("page",furProductMapper.selectQianShi(6));
        model.addAttribute("p",furProductMapper.selectQianShi(6));
        model.addAttribute("pr",furProductMapper.selectQianShi(6));
        model.addAttribute("hot",furProductMapper.selectQianShi(6));
        model.addAttribute("sale",furProductMapper.selectQianShi(3));
        model.addAttribute("special",furProductMapper.selectQianShi(3));
        model.addAttribute("top",furProductMapper.selectQianShi(3));
        return "homepage1";
    }
//商品分类
    @GetMapping("/detail/{type}")
    public String list1(Model model, @PathVariable("type") String type) {
        model.addAttribute("product", furProductMapper.selectByType(type));
        model.addAttribute("hot", furProductMapper.selectQianShi(4));
        model.addAttribute("type",furProductMapper.selectOne(type,1));
        return "product-view";
    }
//展示
    @GetMapping("/show")
    public String list3() {
        return "showAll";
    }
//定制
    @GetMapping("/diy")
    public String list4() {
        return "customize";
    }
//风格分类
    @GetMapping("/lifestyle/id")
    public String list8(Model model,String style,String sname){

        model.addAttribute("style", furStyleMapper.selectByAllStyle(style,sname));
        return "style";
    }
    @GetMapping("/style/{styles}")
    public String list2(Model model, @PathVariable("styles") String styles) {
        model.addAttribute("style", furStyleMapper.selectByStyle(styles));
        return "allstyle";
    }
    //关于
    @GetMapping("/about")
    public String list5() {
        return "about-us";
    }

//商品详情
    @GetMapping("/view{pid}")
    public String list6(Model model,@PathVariable("pid") Long pid){
        FurProduct product=furProductService.getById(pid);
        if(product==null){
            return "homepage1";
        }
        List<FurEvaluate> evaluate=furPictureMapper.selectOrderByPid(pid);
        List<FurPicture> picture=furPictureMapper.selectByPid(pid);
        model.addAttribute("evaluate",evaluate);
        model.addAttribute("picture",picture);
        model.addAttribute("product",product);
        model.addAttribute("pro",furProductMapper.selectQianShi(4));
        return "product-detail";
    }
//排序
    @GetMapping("/details/{type}")
    public String list6(Model model, @PathVariable("type") String type) {
        model.addAttribute("asc", furProductMapper.selectByPriceA(type));
        return "product-view1";
    }
//排序
    @GetMapping("/details2/{type}")
    public String list7(Model model, @PathVariable("type") String type) {
        model.addAttribute("asc",furProductMapper.selectByPriceD(type));
        return "product-view1";
    }


}

