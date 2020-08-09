package com.gem.furniture.web;

import com.gem.furniture.entity.*;
import com.gem.furniture.mapper.*;
import com.gem.furniture.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class GoodsController {

    @Autowired
    FurUserMapper furUserMapper;
    @Resource
    FurUserService furUserService;

    @Autowired
    FurProductService furProductService;
    @Autowired
    FurProductMapper furProductMapper;

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


    @GetMapping("/buyNow")
    public String list2( int[] ids ,Model model,HttpSession session ){
        FurUser u=(FurUser)session.getAttribute("user");
        List<Integer> list1 = Arrays.stream(ids).boxed().collect(Collectors.toList());
        session.setAttribute("ids",list1);
        Collection<FurCart> cart=furCartService.listByIds(list1);
        FurAddress furAddress = furAddressMapper.selectByIsdefault(1,u.getUid());
        if(furAddress==null){
            session.setAttribute("sitenull","0");
            return "redirect:pc";
        }

        model.addAttribute("isdefault",furAddress);
        Double num=0.0;
        for(FurCart c:cart){
            Double num1=0.0;
            num+=c.getPrice()*c.getCount();
            num1=c.getPrice()*c.getCount();
            c.setTotal(num1);
        }
        model.addAttribute("carts",cart);
        model.addAttribute("num",num);


        return "checkout";
    }
    @PostMapping("/buy")
    public String buy( Long pid ,Model model,HttpSession session ){
        SnowFlake snowFlake = new SnowFlake(2, 3);
        FurUser u=(FurUser)session.getAttribute("user");
        FurAddress furAddress = furAddressMapper.selectByIsdefault(1,u.getUid());
        model.addAttribute("isdefault",furAddress);
        Collection<FurCart> cart= furCartMapper.selectByUidPid(pid,u.getUid());
        for(FurCart c:cart){
            FurOrder order=new FurOrder();
            order.setNo(snowFlake.nextId()+"");
            order.setPid(c.getPid());
            order.setUid(u.getUid());
            order.setOrderTime(new Date());
            order.setPrice(c.getPrice());
            order.setCount(c.getCount());
            order.setCateId(1);
            order.setUname(furAddress.getConsignee());
            order.setAddress(furAddress.getProvince()+furAddress.getCity()+furAddress.getArea());
            order.setPhone(furAddress.getPhone());
            furOrderService.save(order);
        }
        model.addAttribute("carts",cart);
        Double num=0.0;
        for(FurCart c:cart){
            System.out.println(c);
            num+=c.getPrice()*c.getCount();
        }
        model.addAttribute("num",num);
        return "checkout";
    }












    @DeleteMapping("/wishs/{pid}")
    @ResponseBody
    public String wishs(@PathVariable("pid") Long pid,HttpSession session){
        return furWishService.romveByPid(pid)?"1":"0";
    }

    @GetMapping("/view")
    public String list5(Model model,Long pid){
        model.addAttribute("product",furProductService.getById(pid));

        return "product-detail";
    }

    /*---------------------------------------------------------------------------------*/

    //个人中心
    @GetMapping("/pc")
    public String Pc(HttpSession session ,Model model){
        FurUser u=(FurUser)session.getAttribute("user");
        FurUser user=furUserService.selectByPhone(u.getPhone());
        model.addAttribute("user",user);
        return "pc";
    }
    //购物车
    @GetMapping("/cart")
    public String list7(Model model,HttpSession session){
        FurUser user= (FurUser) session.getAttribute("user");
        Long uid=user.getUid();
        model.addAttribute("product",furCartMapper.selectByUid(uid));
        return "shopping-cart";
    }
    //收藏
    @GetMapping("/wish")
    public String list(Model model,HttpSession session){
        FurUser user= (FurUser) session.getAttribute("user");
        Long uid=user.getUid();
        model.addAttribute("product",furWishMapper.selectByUid(uid));
        return "wishlist";
    }

}


