package com.pbw.cms.dao;


import com.pbw.cms.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatetoryRepository extends JpaRepository<Category, Long> {
}
