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
public class EquRent {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long projectId;

    @Column
    private Date startTime;

    @Column
    private Date endTime;

    @Column
    private Double rentPrice;

    @Column
    private Double totalPrice;

    @Column
    @CreatedDate
    private Date createTime;


}
