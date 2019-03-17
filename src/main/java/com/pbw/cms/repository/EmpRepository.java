package com.pbw.cms.repository;

import com.pbw.cms.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByStatus(int status);
    List<Employee> findByNameContainsAndSalaryIsLessThan(String name,double salary);

}
