package com.pbw.cms.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description 员工
 * @Author 彭博文的计算机
 * @Date 2019/3/17 7:54
 **/
@Data
@Entity
@Table(name="emp")
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column
    private Long roleId;

    @Column
    private Double salary;

    @Column
    private Integer status;

    @Column
    @CreatedDate
    private Date createTime;

    @OneToOne
    @JoinColumn(name = "roleId",referencedColumnName = "id",insertable = false,updatable = false)
    private Role role;

}
