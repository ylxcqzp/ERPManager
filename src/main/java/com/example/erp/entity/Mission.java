package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * mission 任务表
 * @author qzp
 */
@Data
public class Mission implements Serializable {
    private Integer id;

    /**
     * 项目id
     */
    private Integer pid;

    /**
     * 任务名称
     */
    private String missionName;

    /**
     * 任务详情
     */
    private String missionDetail;

    /**
     * 开始时间
     */
    private Date beginDate;

    /**
     * 截至时间
     */
    private Date endDate;

    /**
     * 状态（0，未开始；1，进行中；2，测试中；3，已完成；4，优化中）
     */
    private Long status;

    private static final long serialVersionUID = 1L;

}