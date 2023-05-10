package com.yxl.application.controller;


import com.yxl.application.entity.Product;
import com.yxl.application.service.IProductService;
import com.yxl.application.util.FileUtil1;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxl
 * @since 2023-05-09
 */
@RestController
@Api("产品")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;




    @GetMapping("/show")
    public List<Product> show(){
        List<Product> list = iProductService.list();
        return  list;
    }


    @PostMapping("/add")
    public String add( Product product, MultipartFile proImg, HttpServletRequest request){
//        String suffix= FileUtil1.getSuffix(proImg.getOriginalFilename());
//        String newFileName = FileUtil1.getNewFileName()+suffix;
        String filename = proImg.getOriginalFilename();
        try {
            proImg.transferTo(new File("E:/photo/"+filename));
            product.setProimg("E:/photo/"+filename);
            iProductService.save(product);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "123";
    }


    @GetMapping
    public String send(){
        return "6";
    }

}
