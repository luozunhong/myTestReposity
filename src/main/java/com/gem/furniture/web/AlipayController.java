package com.gem.furniture.web;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.gem.furniture.entity.*;
import com.gem.furniture.mapper.FurAddressMapper;
import com.gem.furniture.mapper.FurOrderMapper;
import com.gem.furniture.security.AlipayConfig;
import com.gem.furniture.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.*;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class AlipayController {

    @Autowired
    FurOrderService furOrderService;

    @Autowired
    FurOrderMapper furOrderMapper;

    @Autowired
    FurAddressMapper furAddressMapper;
    @Autowired
    FurCartService furCartService;

    @RequestMapping("/pay")
    @ResponseBody
    public String pay(HttpServletRequest request, HttpServletResponse response ,String[] WIDout_trade_no ,HttpSession session ) throws Exception {

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        //付款金额，必填
        String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"), "UTF-8");
        //订单名称，必填
        String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"), "UTF-8");
        //商品描述，可空
        //String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"), "UTF-8");
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
               //+ "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        //输出
        //PrintWriter out = response.getWriter();
        //out.println(result);

        session.setAttribute("WIDout_trade_no",WIDout_trade_no);
        //拿到购物车信息

        return result;
    }

    @RequestMapping("/alipayReturnNotice")
    public String alipayReturnNotice(HttpServletRequest request, HttpSession session) throws Exception {
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
                AlipayConfig.sign_type); //调用SDK验证签名
        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            String[] WIDout_trade_no= (String[]) session.getAttribute("WIDout_trade_no");
            List<Integer> idsa= (List<Integer>) session.getAttribute("ids");
            Collection<FurCart> cart=furCartService.listByIds(idsa);
            //拿到收获信息
            FurUser u=(FurUser)session.getAttribute("user");
            FurAddress furAddress = furAddressMapper.selectByIsdefault(1,u.getUid());
            if(furAddress==null){
                session.setAttribute("sitenull","0");
                return "redirect:pc";
            }
            FurOrder order=new FurOrder();
            int i=0;
            for(FurCart c:cart){
                order.setPname(c.getPname());
                order.setTotal(c.getPrice() * c.getCount());
                order.setPicture(c.getPicture());
                order.setNo(WIDout_trade_no[i]);
                i++;
                order.setPid(c.getPid());
                order.setUid(u.getUid());
                order.setOrderTime(new Date());
                order.setPrice(c.getPrice());
                order.setCount(c.getCount());
                order.setCateId(2);
                order.setUname(furAddress.getConsignee());
                order.setAddress(furAddress.getProvince()+furAddress.getCity()+furAddress.getArea());
                order.setPhone(furAddress.getPhone());
                furOrderService.save(order);
            }
            furCartService.removeByIds(idsa);

            return "redirect:gem/home";
        }
        return "验签失败";
    }
}
