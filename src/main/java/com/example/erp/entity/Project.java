package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;

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

    private static final long serialVersionUID = 1L;

}