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
public class Project {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 项目名称
     */
    @Column
    private String projectName;

    /**
     * 负责人id
     */
    @Column
    private Long headId;

    /**
     * 负责人名称
     */
    @Column
    private String headName;

    /**
     * 开始时间
     */
    @Column
    private Date startTime;

    /**
     * 结束时间
     */
    @Column
    private Date endTime;

    /**
     * 创建时间
     */
    @Column
    @CreatedDate
    private Date createTime;

}
