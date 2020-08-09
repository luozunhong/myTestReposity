package com.gem.furniture.web;

import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.gem.furniture.entity.*;
import com.gem.furniture.mapper.*;
import com.gem.furniture.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WithoutController {
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

    //添加购物车
    @PostMapping("/carts")
    @ResponseBody
    public String list3(Long pid, HttpSession session){
        FurUser user= (FurUser) session.getAttribute("user");
        if(user==null){
            return "-1";
        }
        FurCart cart=new FurCart();
        FurProduct product = furProductMapper.selectByPid(pid);
        FurCart c=furCartMapper.getByPidUid(pid,user.getUid());
        if(c!=null){
            c.setCount(c.getCount()+1);
            Double a = c.getPrice()*c.getCount();
            cart.setTotal(a);
            furCartService.updateById(c);
            return "0";
        }
        cart.setUid(user.getUid());
        cart.setPid(pid);
        cart.setPname(product.getPname());
        cart.setPrice(product.getPrice());
        int num=1;
        cart.setCount(num);
        cart.setPicture(product.getPicture());
        Double a = cart.getPrice()*cart.getCount();
        cart.setTotal(a);
        furCartService.save(cart);
        return "1";
    }


    //收藏
    @PostMapping("/collects")
    @ResponseBody
    public String  collect(long pid ,HttpSession session){
        FurUser user= (FurUser) session.getAttribute("user");
        List<FurWish> w= furWishMapper.selectByUidPid(user.getUid(),pid);
        if(w.size()==0){
            return "0";
        }
        return "1";
    }
    //添加收藏
    @GetMapping("/wishs/{pid}")
    @ResponseBody
    public String list4(Model model,@PathVariable("pid") Long pid,HttpSession session){
        FurUser user= (FurUser) session.getAttribute("user");
        if(user==null){
            return "-1";
        }
        FurWish wish=new FurWish();
        Long uid=user.getUid();
        List<FurWish> furWishes=furWishMapper.selectByUidPid(uid,pid);
        if(furWishes.size()!=0){
            return "0";
        }
        FurProduct product=furProductMapper.selectByPid(pid);
        wish.setUid(uid);
        wish.setPid(pid);
        wish.setPname(product.getPname());
        wish.setPrice(product.getPrice());
        wish.setPicture(product.getPicture());
        furWishService.save(wish);
        return "1";
    }
    //删除收藏
    @DeleteMapping("/wishss/{pid}")
    @ResponseBody
    public String list8(@PathVariable("pid")Long pid,HttpSession session){
        FurUser user= (FurUser) session.getAttribute("user");
        furWishMapper.DeleteByUid(pid,user.getUid());
        return "1";
    }
    //添加购物车
    @PostMapping("/alter")
    @ResponseBody
    public String alter(FurCart cart){
        FurCart furCart = furCartMapper.selectByCid(cart.getCid());

        boolean b=furCartService.updateById(cart);
        return b?"0":"1";
    }


    @GetMapping("/delses")
    @ResponseBody
    public String delses(HttpSession session){
        session.removeAttribute("sitenull");
        return "1";
    }





}

