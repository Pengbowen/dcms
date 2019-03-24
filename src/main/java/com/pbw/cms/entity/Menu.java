package com.pbw.cms.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/17 14:32
 **/
@Data
@Entity
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public class Menu {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long pid;

    @Column
    private String title;

    @Column
    private String path;

    @Column
    private String icon;

    @Column
    private Integer sort;

    /**
     * 模板组件地址
     */
    @Column
    private String  component;

    @Column
    private Boolean open;

    @Column
    private Boolean blank;



    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
    @JoinColumn(name = "pid",insertable = false,updatable = false)
    private List<Menu> children;
}
