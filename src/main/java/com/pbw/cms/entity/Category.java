package com.pbw.cms.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

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
    private Long pid;

    @Column
    private String categoryName;

    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
    @JoinColumn(name = "pid",insertable = false,updatable = false)
    private List<Category> children;

}
