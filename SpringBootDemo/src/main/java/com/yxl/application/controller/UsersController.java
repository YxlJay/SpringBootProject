package com.yxl.application.controller;


import com.alibaba.fastjson.JSON;
import com.aliyun.oss.OSSClient;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yxl.application.config.ALiConfig;
import com.yxl.application.config.MyConfig;
import com.yxl.application.entity.*;
import com.yxl.application.service.IUsersService;
import io.swagger.annotations.Api;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpSession;
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
@Api("用户")
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUsersService iUsersService;

     @Autowired
     private ALiConfig aLiConfig;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private MyConfig myConfig;


    @Autowired
    private RestTemplate restTemplate;
//    @GetMapping("/show")
//    public  List<Users> show(@RequestParam(value = "size",defaultValue = "5")Integer size){
//        Page<Users> objectPage = new Page<>(1,size);
//        List<Users> list = iUsersService.page(objectPage).getRecords();
//        return list;
//    }

    @GetMapping("{pageNum}/{pageSize}")
    public List<Users> shows(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        Page<Users> page = new Page<>(pageNum, pageSize);
        IPage<Users> getUser = iUsersService.page(page);
        return getUser.getRecords();
    }

    @GetMapping("{id}")
    public Users showone(@PathVariable("id") Integer id){
        Users byId = iUsersService.getById(id);
//        myConfig.send();
        return byId;
    }
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id")Integer id){
        iUsersService.removeById(id);
        return "11";
    }

    @PutMapping()
    public String update(@RequestBody Users users){
      iUsersService.updateById(users);
       return "8";
    }

    @PostMapping()
    public  String  save(@RequestBody Users users){
        iUsersService.save(users);
         return "9";
    }

    @RequestMapping("/q")
    public String q(HttpSession session){
        redisTemplate.boundValueOps("s").set("asd");
        session.setAttribute("l","l");
        return "l";
    }

    @GetMapping("/send")
    public  String send(){

        amqpTemplate.convertAndSend("springDirect","666","aa".getBytes());
        return "777";
    }


    @PostMapping("/upload")
    public String upload(MultipartFile image){
        OSSClient client=new OSSClient(aLiConfig.getEndpoint(),aLiConfig.getAccesskey(),aLiConfig.getAccesssecret());
        try {
            client.putObject(aLiConfig.getBucket(),image.getOriginalFilename(),image.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            client.shutdown();
        }
        return "";
    }


    @GetMapping("/http")
    @ResponseBody
    public String http( String city){
        String url= "http://apis.juhe.cn/simpleWeather/query?key=c5226d7edf824142d52ef181981c2936&city="+city;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        String body = forEntity.getBody();
        ResVo resVo = JSON.parseObject(body, ResVo.class);
        System.out.println("resVo = " + resVo);
        String result = resVo.getResult();
        ReVo reVo = JSON.parseObject(result, ReVo.class);
        System.out.println("reVo = " + reVo);
        String realtime = reVo.getRealtime();
        Realtime realtime1 = JSON.parseObject(realtime, Realtime.class);
        System.out.println("realtime1 = " + realtime1);
        return body;
    }
    @GetMapping("/news")
    public String news(  String  type,@RequestParam(value = "page",defaultValue = "1")Integer page,@RequestParam(value = "page_size",defaultValue = "30")Integer 	page_size,@RequestParam(value = "is_filter",defaultValue = "0") Integer is_filter){
        String url= "http://apis.juhe.cn/simpleWeather/query?key=c7435501edb8757f7f7b3524760b8249&type="+type+"&page="+page+"&page_size="+page_size+"&is_filter="+is_filter;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        String body = forEntity.getBody();
        return body;
    }
}
