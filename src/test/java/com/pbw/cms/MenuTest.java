package com.pbw.cms;

import com.pbw.cms.entity.Menu;
import com.pbw.cms.dao.MenuRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/17 15:02
 **/
public class MenuTest extends CmsApplicationTests {

    @Autowired
    private MenuRepository menuRepository;

    @Test
    public void addMenu(){
        menuRepository.deleteAll();
        Menu menu = new Menu();
        menu.setIcon("layui-icon-home");
        menu.setPid(0L);
        menu.setTitle("主页");
        menu.setBlank(false);
        menu.setOpen(false);
        Menu save = menuRepository.save(menu);

    }

    @Test
    public void testFind(){
        List<Menu> all = menuRepository.findByPidEqualsOrderBySort(0L);
        for (Menu menu : all) {
            System.out.println(menu);
        }
    }

    @Test
    public void test2(){
        List<Menu> all = menuRepository.findAll();
        String [] arr = {
                "/layui/flow",
                "/menu/list"
        };

        String [] arr1 = {
                "views/layui/flow.html",
                "views/menu/menu.html",
        };
        all.forEach(menu->{
            int i =  new Random().nextInt(2);
            if (menu.getPid() == 0){
                menu.setPath(null);
            }else{
                menu.setPath(arr[i]);
                menu.setComponent(arr1[i]);
            }
            menu.setOpen(true);
            menu.setBlank(false);

        });
        menuRepository.saveAll(all);
    }
}
