package com.gem.furniture.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.furniture.entity.FurEvaluate;
import com.gem.furniture.entity.FurProduct;
import com.gem.furniture.mapper.FurProductMapper;
import com.gem.furniture.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@SessionAttributes("fileName")
public class ProductController {

    @Autowired
    FurProductMapper furProductMapper;
    @Value("${web.upload-path}")
    private String dir;
    @Autowired
    FurProductService productService;
    @Autowired
    FurOrderService orderService;
    @Autowired
    FurUserService userService;
    @Autowired
    FurProductMapper productMapper;
    @Autowired
    FurEvaluateService evaluateService;


    //上架商品
    @GetMapping("/product-list")
    public String showHome(Model model) {
        //查询商品
        IPage<FurProduct> page = productService.page(new Page<>(1, 5));
        model.addAttribute("page", page);
        return "product-list";
    }
    @GetMapping("/product-lists/{current}")
    public String showHomes(Model model,@PathVariable("current") int current) {

        IPage<FurProduct> page = productService.page(new Page<>(current, 5));
        model.addAttribute("page", page);
        if(current>page.getPages()){
            return "redirect:/product-lists/"+page.getPages();
        }
        return "product-list";

    }
    //评价页面
    @RequestMapping("/evaluate")
    public String showHome2(Model model) {
        IPage<FurEvaluate> page = evaluateService.page(new Page<>(1, 10));
        model.addAttribute("page", page);
        return "evaluate";
    }
    @RequestMapping("/evaluate/{current}")
    public String showHome22(Model model,@PathVariable("current") int current) {
        IPage<FurEvaluate> page = evaluateService.page(new Page<>(current, 10));
        model.addAttribute("page", page);
        if(current>page.getPages()){
            return "redirect:/evaluate/"+page.getPages();
        }
        return "evaluate";
    }
    //商品页面

    @GetMapping("/product-add")
    public String show() {
        return "product-add";
    }
    @RequestMapping("/head")
    public String showHome3(Model model,@RequestParam("file") MultipartFile file) throws Exception {
        String originalName = file.getOriginalFilename();
        String suffix = originalName.substring(originalName.lastIndexOf("."));
        String fileName = System.currentTimeMillis() + suffix;
        File newFile = new File(dir, fileName);
        file.transferTo(newFile);
        model.addAttribute("fileName",fileName);
        return "product-add";
    }
    //添加商品

    @PostMapping("/product-add")
    @ResponseBody
    public String showHome3(FurProduct product,@SessionAttribute("fileName")String fileName)  {
        product.setPicture(fileName);
        productService.save(product);
        return "成功";
    }

    //修改商品页面

    @RequestMapping("/product-edit/{id}")
    public String showHome4(@PathVariable("id")Long id, HttpSession session,Model model){
        FurProduct product=productMapper.selectByPid(id);
        session.setAttribute("pid",id);
        model.addAttribute("product",product);
        return "product-edit";
    }
    //修改商品

    @RequestMapping("/productedit")
    @ResponseBody
    public String showHome5(HttpSession session,FurProduct product){
        product.setPid((Long) session.getAttribute("pid"));
        productService.saveOrUpdate(product);
        return "修改成功";
    }

    //逻辑单个删除商品
    @DeleteMapping("/product-list/{pid}")
    @ResponseBody
    public String delete(@PathVariable("pid") Long pid){
        boolean isSuccess=productService.removeById(pid);
        if (isSuccess){
            return "1";
        }
        return "0";
    }
    //逻辑批量删除商品

    @DeleteMapping("/product-list")
    @ResponseBody
    public String deleteBench(@RequestParam("ids") int[] ids){
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(Integer i:ids){
            arrayList.add(i);
        }
        productMapper.deleteBatchIds(arrayList);
        return "1";
    }

//查询下架商品

    @GetMapping("/product-list1")
    public String show(Model model) {
        Page<FurProduct> p = new Page<>(1,5);
        QueryWrapper<FurProduct> qw = new QueryWrapper<>();
        qw.eq("status",1);
        IPage<FurProduct> page= productMapper.selectByStatus(p,qw);
        model.addAttribute("page", page);
        return "product-list1";

    }
    @GetMapping("/product-list1/{current}")
    public String show1(Model model,@PathVariable("current") int current) {
        Page<FurProduct> p = new Page<>(current,5);
        QueryWrapper<FurProduct> qw = new QueryWrapper<>();
        qw.eq("status",1);
        System.out.println(qw);
        IPage<FurProduct> page= productMapper.selectByStatus(p,qw);
        model.addAttribute("page", page);
        return "product-list1";

    }
//真删除商品

    @DeleteMapping("/product-list1/{pid}")
    @ResponseBody
    public String deleteTure(@PathVariable("pid") Long pid){
        boolean isSuccess=productMapper.deleteByyId(pid);
        if (isSuccess){
            return "1";
        }
        return "0";
    }

    //上架商品

    @RequestMapping("/product-list2")
    @ResponseBody
    public String update(Long pid){
        boolean isSuccess= productMapper.updateStatus(pid);
        if (isSuccess){
            return "1";
        }
        return "0";

    }
    //批量上架商品
    @RequestMapping("/product_list4")
    @ResponseBody
    public String updates(Long[] ids){
        List<Long> list = Arrays.asList(ids);
        //ArrayList<Integer> list=new ArrayList<>();

        List<FurProduct> pro= productMapper.selectBatchIds(list);
        for(FurProduct i:pro){
            i.setStatus(0);
            productService.saveOrUpdate(i);
        }
        return "1";

    }

    //批量上架商品
    @RequestMapping("/productup")
    @ResponseBody
    public String productup( Long[] ids){
        List<FurProduct> products=new ArrayList<>();
        for( Long i:ids){
            FurProduct p =  productMapper.selectStatusByIds(i);
            products.add(p);
        }
        for(int i=0;i<ids.length;i++){

            productMapper.updateStatus(ids[i]);
        }
        return "1";

    }


}
