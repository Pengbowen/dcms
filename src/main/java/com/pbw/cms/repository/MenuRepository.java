package com.pbw.cms.repository;

import com.pbw.cms.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/17 14:48
 **/
public interface MenuRepository extends JpaRepository<Menu,Long> {
   List<Menu> findByPidEqualsOrderBySort(final Long pid);
}
