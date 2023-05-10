package com.yxl.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/10 14:29
 **/
@RestController
public class TypeController {

    @GetMapping("/type/list")
    private R show(){
        List list = new ArrayList();
        Type type = new Type(1,"食品");
        Type type2 = new Type(2,"服装");
        list.add(type);
        list.add(type2);
        return new R(200,list);
    }
}
