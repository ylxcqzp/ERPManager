package com.example.erp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * mission
 * @author 
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
     * 负责人
     */
    private Employee employee;

    /**
     * 参与人
     */
    private String invoke;

    /**
     * 标签
     */
    private String tag;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date beginDate;

    /**
     * 截至时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date endDate;

    /**
     * 状态（0，未开始；1，进行中；2，测试中；3，已完成；4，优化中）
     */
    private Long status;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date createDate;

}