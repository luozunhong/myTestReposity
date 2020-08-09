package com.gem.furniture.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.furniture.entity.*;
import com.gem.furniture.mapper.FurCartMapper;
import com.gem.furniture.mapper.FurUserMapper;
import com.gem.furniture.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class OrderController {
    @Autowired
    FurOrderService orderService;


    @Autowired
    FurUserService furUserService;

    @Autowired
    FurCartService furCartService;
    @Autowired
    FurProductService productService;
    @Autowired
    FurUserMapper userMapper;
    @Autowired
    FurCartMapper furCartMapper;


    @RequestMapping("/order-add")
    public String orderAdd(){
        return "order-add";
    }



    @RequestMapping("/order-edit")
    public String order(){

        return "order-edit";
    }


    @RequestMapping("/order-table")
    public String aa(Model model) {
        Page<FurOrder> p = new Page<>(1,5);
        QueryWrapper qw = new QueryWrapper();
        qw.isNotNull("pid");
        qw.orderByDesc("oid");
        IPage<FurOrder> pages= orderService.selectAllFurOrder(p,qw);
        model.addAttribute("pages",pages);
        return "order-table";
    }

    @RequestMapping("/orderlist")
    public String showHome1(Model model) {
        Page<FurOrder> p = new Page<>(1,5);
        QueryWrapper qw = new QueryWrapper();
        qw.isNotNull("pid");
        qw.orderByDesc("oid");

        IPage<FurOrder> pages= orderService.selectAllFurOrder(p,qw);
        model.addAttribute("pages",pages);
        return "orderlist";
    }
    @RequestMapping("/orderlist/{current}")
    public String showHome2(Model model,@PathVariable("current") int current) {
        Page<FurOrder> p = new Page<>(current,5);
        QueryWrapper qw = new QueryWrapper();
        qw.isNotNull("uid");
        qw.orderByDesc("oid");

        IPage<FurOrder> pages= orderService.selectAllFurOrder(p,qw);
        model.addAttribute("pages",pages);
        if(current>pages.getPages()){
            return "redirect:/orderlist/"+pages.getPages();
        }
        return "order-table";
    }
//后台管理欢迎界面

    @RequestMapping("/welcome")
    public String home(Model model){

        int count = furUserService.count();
        int count1=productService.count();
        int count2=orderService.count();
        model.addAttribute("count", count);
        model.addAttribute("count1", count1);
        model.addAttribute("count2", count2);

        return "welcome";
    }
    //后台修改订单页面
    @RequestMapping("/order-edit/{id}")
    public String order(@PathVariable("id")Long id, HttpSession session,Model model){
        FurOrder order=orderService.getById(id);
        model.addAttribute("order",order);
        session.setAttribute("oid",id);
        return "order-edit";

    }
    //后台修改订单
    @RequestMapping("/orderedit")
    @ResponseBody
    public String editOrder( HttpSession session,FurOrder order){
        order.setOid((long)session.getAttribute("oid"));
        boolean isSuccess=orderService.updateById(order);
        if (isSuccess){
            return "1";
        }
        return "0";

    }

    //后台批量删除订单
    @DeleteMapping("/orderlist")
    @ResponseBody
    public String deleteBench1(@RequestParam("ids") int[] oids){
        if (oids!=null){
            for (int i=0;i<oids.length;i++){
                boolean a=orderService.removeById(oids[i]);
            }
        }
        return "1";
    }
    //单个删除订单
    @DeleteMapping("/orderlist/{oid}")
    @ResponseBody
    public String delete(@PathVariable("oid") Long oid){
        boolean isSuccess=orderService.removeById(oid);
        if (isSuccess){
            return "1";
        }
        return "0";
    }
    //按日期区间查询
    @RequestMapping("/orderlist1")
    public String selectByTimes(String start,String end,Model model){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date date1 = null;
        try {
            date = format.parse(start);
            date1 = format.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        QueryWrapper qw = new QueryWrapper();
        qw.gt("order_time",date);
        qw.lt("order_time",date1);
        Page<FurOrder> p = new Page<>(1,5);
        IPage<FurOrder> pages= orderService.findByTimes(p,qw);
        model.addAttribute("pages",pages);
        return "order-table";
    }
    //订单编号查询
    @RequestMapping("/orderlist2")
    public String findByNO(Model model,String no){
        Page<FurOrder> p = new Page<>(1,5);
        QueryWrapper qw = new QueryWrapper();
        qw.like("no",no);
        IPage<FurOrder> pages = orderService.findByTimes(p,qw);
        // FurOrder pages=orderService.findOrderByNo(no);
        model.addAttribute("pages",pages);
        return "order-table";
    }
    //订单状态查询
    @RequestMapping("/orderlist3")
    public String findByOrderStatus(Model model,String orderStatus){
        System.out.println(orderStatus);
        Page<FurOrder> p = new Page<>(1,5);
        QueryWrapper qw = new QueryWrapper();
        qw.like("cate_id",orderStatus);
        IPage<FurOrder> pages = orderService.findByOrderStatus(p,qw);
        model.addAttribute("pages",pages);
        return "order-table";
    }
    @RequestMapping("/orderlist4")
    public  String findByName(Model model,String uname){
        Page<FurOrder> p = new Page<>(1,5);
        QueryWrapper qw=new QueryWrapper();
        qw.eq("uname",uname);
        IPage<FurOrder> pages= (IPage<FurOrder>) orderService.findOrderByName(p,qw);
        model.addAttribute("pages",pages);
        return "order-table";
    }



}
