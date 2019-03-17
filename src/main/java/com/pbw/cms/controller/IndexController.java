package com.pbw.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/17 12:58
 **/
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
