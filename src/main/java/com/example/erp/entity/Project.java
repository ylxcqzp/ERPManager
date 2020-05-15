package com.example.erp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Project 项目信息
 * @author qzp
 */
@Data
public class Project implements Serializable {
    private Integer id;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 详情说明
     */
    private String detail;

    /**
     * 状态（0，未开始；1进行中；2测试中，3，已完成）
     */
    private Byte status;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date createDate;

}