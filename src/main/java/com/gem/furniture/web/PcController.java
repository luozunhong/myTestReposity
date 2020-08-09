package com.gem.furniture.web;


import com.gem.furniture.entity.*;
import com.gem.furniture.mapper.*;
import com.gem.furniture.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class PcController {
    @Autowired
    FurUserService furUserService;
    @Autowired
    FurAddressService furAddressService;
    @Autowired
    FurAddressMapper furAddressMapper;
    @Autowired
    FurEvaluateMapper furEvaluateMapper;
    @Autowired
    FurOrderMapper furOrderMapper;
    @Autowired
    FurOrderService furOrderService;



    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/address")
    public String address(Model model,HttpSession session) {
        FurUser u=(FurUser)session.getAttribute("user");
        List<FurAddress> furAddresses = furAddressMapper.selectByIsdefaul(0,u.getUid());
        model.addAttribute("furaddress",furAddresses);
        FurAddress furAddress = furAddressMapper.selectByIsdefault(1,u.getUid());
        model.addAttribute("isdefault",furAddress);
//地址管理
        return "address";
    }

    @RequestMapping("/bindphone")
    public String bindphone() {
//绑定手机
        return "bindphone";
    }
    @RequestMapping("/change")
    public String change() {
//退换货管理
        return "change";
    }
    @RequestMapping("/collection")
    public String collection() {
//我的收藏
        return "collection";
    }
    //评论
    @RequestMapping("/comment")
    public String comment(HttpSession session,Model model) {
        FurUser user = (FurUser) session.getAttribute("user");
        List<FurEvaluate> furEvaluates = furEvaluateMapper.selectEvaluateById(user.getUid());
        model.addAttribute("furEvaluates",furEvaluates);
        return "comment";
    }
    @RequestMapping("/commentlist")
    public String commentlist() {
//评论
        return "commentlist";
    }
    @RequestMapping("/idcard")
    public String idcard() {
//实名认证
        return "idcard";
    }
    @GetMapping("/information")
    public String information(Model model , HttpSession session){
        FurUser u=(FurUser)session.getAttribute("user");

        FurUser user=furUserService.selectByPhone(u.getPhone());
        System.out.println(u);
        model.addAttribute("user",user);
        return "information";
    }
    @PostMapping("/info")
    @ResponseBody
    public String UpdateInformation(FurUser user ,String time ,HttpSession session){
        System.out.println(user);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        user.setBirthDate(date);
        furUserService.updateById(user);

        session.setAttribute("user",furUserService.selectByPhone(user.getPhone()));
        return "修改成功";
    }
    //所有订单
    @RequestMapping("/order")
    public String order(Model model,HttpSession session) {
        FurUser furUser=  (FurUser) session.getAttribute("user");
        List<FurOrder> orders = furOrderMapper.selectNoById(furUser.getUid());
        model.addAttribute("orders",orders);
        return "order";
    }
    //待付款
    @RequestMapping("/order1")
    public String order1(Model model,HttpSession session) {
        FurUser furUser=  (FurUser) session.getAttribute("user");
        List<FurOrder> orders1 = furOrderMapper.selectOrdersByCate(1,furUser.getUid());
        model.addAttribute("orders",orders1);
        return "order1";
    }

    //待发货
    @RequestMapping("/order2")
    public String order2(Model model,HttpSession session) {
        FurUser furUser=  (FurUser) session.getAttribute("user");
        List<FurOrder> orders2 = furOrderMapper.selectOrdersByCate(2,furUser.getUid());
        model.addAttribute("orders",orders2);
        return "order1";
    }
    //待收货
    @RequestMapping("/order3")
    public String order3(Model model,HttpSession session) {
        FurUser furUser=  (FurUser) session.getAttribute("user");
        List<FurOrder> orders3 = furOrderMapper.selectOrdersByCate(3,furUser.getUid());
        model.addAttribute("orders",orders3);
        return "order1";
    }
    //待评价
    @RequestMapping("/order4")
    public String order4(Model model,HttpSession session) {
        FurUser furUser=  (FurUser) session.getAttribute("user");
        List<FurOrder> orders4 = furOrderMapper.selectOrdersByCate(4,furUser.getUid());
        model.addAttribute("orders",orders4);
        return "order1";
    }

    //所有订单
    @RequestMapping("/order5")
    public String order5(Model model,HttpSession session) {
        FurUser furUser=  (FurUser) session.getAttribute("user");
        List<FurOrder> orders5 = furOrderMapper.selectNoById(furUser.getUid());
        model.addAttribute("orders",orders5);
        return "order1";
    }
    @RequestMapping("/options")
    public String options() {
//修改密码
        return "options";
    }
    @RequestMapping("/amend")
    @ResponseBody
    public String amend(String password ,String newpwd ,HttpSession session) {
        FurUser u=(FurUser)session.getAttribute("user");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String pwd=bCryptPasswordEncoder.encode(newpwd);
        if("123".equals(password)){
            u.setPassword(pwd);
            furUserService.updateById(u);
            return "成功";
        }

        return "失败";
        //修改密码
    }
    @RequestMapping("/checkout")
    public String checkout() {
//订单结算
        return "order-checkout";
    }
    @RequestMapping("/orderinfo")
    public String orderinfo() {
//订单结算
        return "orderinfo";
    }
    @RequestMapping("/password")
    public String password() {
//
        return "password";
    }
    @RequestMapping("/safety")
    public String sefety() {
//安全设置
        return "safety";
    }
    @GetMapping("/setpay")
    public String setpay(Model model , HttpSession session){
        FurUser u=(FurUser)session.getAttribute("user");
        FurUser user=furUserService.selectByName(u.getUname());
        model.addAttribute("user",user);
//支付密码
        return "setpay";
    }
    @PostMapping("/setpays")
    @ResponseBody
    public String UpdateSetpay(String payWord,String newpayWord,HttpSession session){
        if(payWord.equals(newpayWord)){
            FurUser u=(FurUser)session.getAttribute("user");
            u.setPayWord(payWord);
            furUserService.updateById(u);
            return "设置成功";
        }
//支付密码
        return "失败";
    }

}
