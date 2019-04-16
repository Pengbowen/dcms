package com.pbw.cms.controller;

import com.pbw.cms.entity.Employee;
import com.pbw.cms.repository.EmpRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/17 8:08
 **/
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpRepository repository;

    @GetMapping("/{empId}")
    @ResponseBody
    @ApiOperation(value="获取员工详细信息", notes="根据员工的id来获取用户详细信息")
    @ApiImplicitParam(name = "empId", value = "员工ID", required = true, dataType = "Long", paramType = "path")
    public Employee getEmpById(@PathVariable Long empId){
        Optional<Employee> result = repository.findById(empId);
        Employee employee = result.get();
        return  employee;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Employee> listAll(){
        List<Employee> employees = repository.findAll();
        return  employees;
    }

    @PostMapping("/add")
    @ResponseBody
    public String addEmp(Employee employee){
        Employee save = repository.save(employee);
        if (save != null){
            return "ok";
        }
        return "false";
    }

//    public String modify(){
//
//    }
//
//    public String del(){
//
//    }





}
