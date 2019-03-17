package com.pbw.cms.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @Description 类别
 * @Author 彭博文的计算机
 * @Date 2019/3/17 11:08
 **/
@Data
@Entity
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long categoryName;
}
