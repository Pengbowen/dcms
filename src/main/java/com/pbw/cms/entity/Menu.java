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
    private String name;

    @Column
    private String title;

    @Column
    private String jump;

    @Column
    private String icon;

    @Column Integer sort;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pid")
    private List<Menu> list;
}
