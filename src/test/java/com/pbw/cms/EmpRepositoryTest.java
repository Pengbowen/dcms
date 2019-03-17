package com.pbw.cms;

import com.alibaba.fastjson.JSONObject;
import com.pbw.cms.entity.Employee;
import com.pbw.cms.repository.EmpRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/17 8:19
 **/
public class EmpRepositoryTest  extends  CmsApplicationTests{

    @Autowired
    private EmpRepository empRepository;

    @Test
    public void testAdd(){
        Employee employee = new Employee();
        employee.setName("李四2");
        employee.setId(1L);
        employee.setStatus(1);
        employee.setSalary(600d);
        Employee save = empRepository.saveAndFlush(employee);
        Assert.assertNotNull(save);
    }

    @Test
    public void testFind(){
        Employee employee = new Employee();
        employee.setStatus(1);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.caseSensitive());
        Example<Employee> example = Example.of(employee,matcher);
        List<Employee> all = empRepository.findAll(example);
        System.out.println(JSONObject.toJSONString(all));
        Assert.assertNotNull(all);
    }

    @Test
    public void testManyFind(){
        List<Employee> than = empRepository.findByNameContainsAndSalaryIsLessThan("李", 550.0);
        System.out.println(JSONObject.toJSONString(than));
    }

    @Test
    public void test3(){
        List<Employee> all = empRepository.findAll();
        all.forEach(o->{
            o.setRoleId(4L);
        });
       empRepository.saveAll(all);
    }

    @Test
    public void test4(){
        List<Employee> byStatus = empRepository.findByStatus(1);
        System.out.println(byStatus.get(0));
    }
}
