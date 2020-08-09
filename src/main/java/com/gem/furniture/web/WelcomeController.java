package com.gem.furniture.web;

import com.gem.furniture.entity.FurEvaluate;
import com.gem.furniture.entity.FurOrder;
import com.gem.furniture.mapper.FurOrderMapper;
import com.gem.furniture.service.FurEvaluateService;
import com.gem.furniture.service.FurOrderService;
import com.gem.furniture.service.FurUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class WelcomeController {

    @Autowired
    FurOrderService furOrderService;

    @Autowired
    FurOrderMapper furOrderMapper;
    @Autowired
    FurEvaluateService furEvaluateService;

    @GetMapping("/add/{no}")

    public String add(@PathVariable("no") String no, Model model){
        model.addAttribute("no",no);
        return "add";
    }

    @PostMapping("/uploadContent")
    public String uploadContent(String comment,String no) {
        //这里只是做了打印,后面可以调用service把内容保存到数据库中

        FurOrder furOrder =  furOrderMapper.selectOrderByNo(no);
        FurEvaluate furEvaluate = new FurEvaluate();
        System.out.println(no);
        System.out.println(furOrder);
        furEvaluate.setComment(comment);
        furEvaluate.setPid(furOrder.getPid());
        furEvaluate.setUid(furOrder.getUid());
        furEvaluate.setIsImage(furOrder.getPicture());
        furEvaluate.setPname(furOrder.getPname());
        furEvaluate.setUname(furOrder.getUname());
        Date data = new Date();
        furEvaluate.setDateTime(data);
        furEvaluateService.save(furEvaluate);
        return "redirect:pc";
    }

    @PostMapping("/uploadImage")
    public FurEvaluate uploadImage(MultipartFile file) {
        String originalName = file.getOriginalFilename();
        String suffix = originalName.substring(originalName.lastIndexOf("."));
        String fileName = System.currentTimeMillis() + suffix;
        File newFile = new File("D:/image/" + fileName);
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
            return new FurEvaluate("1", "上传失败" + e.getMessage());
        }
        return new FurEvaluate("0", fileName);
    }
}
