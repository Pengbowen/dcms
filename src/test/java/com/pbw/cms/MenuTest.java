package com.pbw.cms;

import com.pbw.cms.entity.Menu;
import com.pbw.cms.repository.MenuRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
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
        menu.setName("homepage");
        Menu save = menuRepository.save(menu);

    }

    @Test
    public void testFind(){
        List<Menu> all = menuRepository.findByPidEqualsOrderBySort(0L);
        for (Menu menu : all) {
            System.out.println(menu);
        }
    }
}
