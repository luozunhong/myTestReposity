package com.gem.furniture.web;

import com.aliyuncs.*;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.gem.furniture.entity.FurUser;
import com.gem.furniture.mapper.FurProductMapper;
import com.gem.furniture.mapper.FurUserMapper;
import com.gem.furniture.service.FurProductService;
import com.gem.furniture.service.FurUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

@Controller
@SessionAttributes("user")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    FurUserMapper furUserMapper;
    @Resource
    FurUserService furUserService;

    @Autowired
    FurProductService furProductService;
    @Autowired
    FurProductMapper furProductMapper;


    @RequestMapping("/index")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        return "/index";
    }

    //跳转到登录
    @RequestMapping("/gem/login")
    public String login() {

        return "/loginpage";
    }

    //跳转到注册
    @RequestMapping("/gem/register")
    public String register() {
        return "/registerpage";
    }




    //修改绑定
    @PostMapping("/xgbd")
    @ResponseBody
    public String xgbd(String verify,String phone2,HttpSession session) {
        String ver = session.getAttribute("verifys")+"";
        if(ver.equals(verify)){
            FurUser furUser = (FurUser) session.getAttribute("user");
            furUser.setPhone(phone2);
            furUserService.updateById(furUser);
            return "1";
        }else{
            return "0";
        }
    }

    //获取手机验证码
    @PostMapping("/verify")
    @ResponseBody
    public String verify(String phone,HttpSession session) {

       int ran = (int)(Math.random()*1000000);
        /* session.setAttribute("verifys",ran);
        System.out.println("/////////////////////");
        System.out.println(phone);
        System.out.println(ran);*/
        DefaultProfile profile = DefaultProfile.getProfile("shanghai", "LTAI4Fe7x6c1DTZHRW8LiA5n", "4Uay6c7m5I7qoza70tbHMdhmer6JG0");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "shanghai");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "我的练习");
        request.putQueryParameter("TemplateCode", "SMS_176942095");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+ran+"\"}");
        session.setAttribute("verifys",ran);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "发送成功";
    }















    //登录失败
    @RequestMapping("/login/error")
    @ResponseBody
    public void loginError(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        AuthenticationException exception =
                (AuthenticationException) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            response.getWriter().write(exception.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}