package com.pbw.cms.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/17 10:37
 **/
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String roleName;

}
