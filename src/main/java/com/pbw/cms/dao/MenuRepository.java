package com.pbw.cms.dao;

import com.pbw.cms.entity.Menu;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/17 14:48
 **/
public interface MenuRepository extends JpaRepository<Menu,Long> {
   List<Menu> findByPidEqualsOrderBySort(final Long pid);

   @Modifying
   @Transactional
   @Query(value = "delete from menu where id = ?1 or pid = ?1",nativeQuery = true)
   @Cacheable(value = "menu",key = "targetClass + methodName+#p0")
   void deleteAllByIdIsOrPidIs(long id);
}
