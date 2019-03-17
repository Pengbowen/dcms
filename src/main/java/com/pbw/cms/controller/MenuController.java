package com.pbw.cms.controller;

import com.pbw.cms.entity.Menu;
import com.pbw.cms.entity.ResultMsg;
import com.pbw.cms.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/17 15:20
 **/
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/listAllParent")
    @ResponseBody
    public ResultMsg<List<Menu>> findAllParentMenu(){
        List<Menu> menus = menuRepository.findByPidEqualsOrderBySort(0L);
        return  new ResultMsg<>(0,"ok",menus);
    }

    @GetMapping("/listAll")
    @ResponseBody
    public ResultMsg<List<Menu>> findAll(){
        List<Menu> menus = menuRepository.findAll(Sort.by(Sort.Order.by("sort")));
        return  new ResultMsg<>(0,"ok",menus);
    }


}
