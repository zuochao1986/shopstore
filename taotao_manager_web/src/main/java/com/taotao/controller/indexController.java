package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }
    //当url是item-list的时候,方法返回的string值也是item-list,url是什么,返回值就是什么,由此改造成通用的
    @RequestMapping("/{page}")
    public String showPage(@PathVariable(value = "page") String page){
        return page;
    }
}
