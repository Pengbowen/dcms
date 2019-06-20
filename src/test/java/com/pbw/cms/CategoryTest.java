package com.pbw.cms;

import com.pbw.cms.dao.CatetoryRepository;
import com.pbw.cms.dao.RoleRepository;
import com.pbw.cms.entity.Category;
import com.pbw.cms.entity.Role;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/17 10:39
 **/
public class CategoryTest extends  CmsApplicationTests{
    @Autowired
    CatetoryRepository catetoryRepository;
    @Test
    public void testAdd(){
        Category category = new Category();
        category.setPid(0L);
        category.setCategoryName("灯光器材");
        Category category1 = catetoryRepository.save(category);
        System.out.println(category1.getId());
        Assert.assertNotNull(category1);
    }

    @Test
    public void testFind(){
        Category category = new Category();
    }
}
