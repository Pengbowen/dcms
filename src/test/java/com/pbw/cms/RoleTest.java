package com.pbw.cms;

import com.pbw.cms.entity.Role;
import com.pbw.cms.dao.RoleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/17 10:39
 **/
public class RoleTest  extends  CmsApplicationTests{
    @Autowired
    private RoleRepository roleRepository;
    @Test
    public void testAdd(){
        Role role = new Role();
        role.setRoleName("大助理");
        Role save = roleRepository.save(role);
        Assert.assertNotNull(save);
    }
}
