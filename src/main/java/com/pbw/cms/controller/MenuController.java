package com.pbw.cms.controller;

import com.pbw.cms.entity.Menu;
import com.pbw.cms.entity.ResultMsg;
import com.pbw.cms.repository.MenuRepository;
import com.pbw.cms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private MenuService menuService;

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

    @PostMapping("/add")
    @ResponseBody
    public ResultMsg add(@RequestBody Menu menu){
          Menu save = menuRepository.save(menu);
        return new ResultMsg(0,"ok",save);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResultMsg update(@RequestBody Menu menu){
        Menu save = menuRepository.saveAndFlush(menu);
        return new ResultMsg(0,"ok",save);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResultMsg delete(@PathVariable Long id){
        menuService.deleteMenuAndChildren(id);
        return new ResultMsg(0,"ok",null);
    }
}
