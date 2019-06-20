package com.pbw.cms.dao;

import com.pbw.cms.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/17 10:38
 **/
public interface RoleRepository extends JpaRepository<Role,Long> {
}
