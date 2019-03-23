package com.pbw.cms.service.impl;

import com.pbw.cms.entity.Menu;
import com.pbw.cms.repository.MenuRepository;
import com.pbw.cms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/23 22:29
 **/
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;


    @Override
    public void deleteMenuAndChildren(long id) {
        menuRepository.deleteAllByIdIsOrPidIs(id);
    }
    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu save(Menu obj) {
        return menuRepository.save(obj);
    }

    @Override
    public Menu findById(Long aLong) {
        return menuRepository.findById(aLong).get();
    }

    @Override
    public void deleteById(Long aLong) {
      menuRepository.deleteById(aLong);
    }

    @Override
    public void update(Menu obj) {
      menuRepository.saveAndFlush(obj);
    }


}
