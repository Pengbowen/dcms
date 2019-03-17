package com.pbw.cms.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description
 * @Author 彭博文的计算机
 * @Date 2019/3/17 11:08
 **/
@Data
@Entity
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public class Equ {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 设备编号
     */
    @Column
    private String equCode;

    /**
     * 设备名称
     */
    @Column
    private String equName;

    /**
     * 设备分类
     */
    @Column
    private Long categoryId;

    /**
     * 设备分类对象
     */
    @OneToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "id",insertable = false,updatable = false)
    private Category category;

    /**
     * 设备价格
     */
    @Column
    private Double worth;

    /**
     * 设备租赁单价/日
     */
    @Column
    private Double rentPrice;

    /**
     * 设备状态
     */
    @Column
    private String status;

    /**
     * 设备购买时间
     */
    @Column
    private Date buyTime;

    /**
     * 记录创建时间
     */
    @Column
    @CreatedDate
    private Date createTime;



}
