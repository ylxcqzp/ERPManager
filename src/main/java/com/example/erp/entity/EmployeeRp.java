package com.example.erp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工奖罚表
 * @author 
 */
@Data
public class EmployeeRp implements Serializable {
    private Integer id;

    /**
     * 员工编号
     */
    private Employee employee;

    /**
     * 奖罚日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date rpDate;

    /**
     * 奖罚原因
     */
    private String rpReason;

    /**
     * 奖罚分
     */
    private Integer rpPoint;

    /**
     * 奖罚类别，0：奖，1：罚
     */
    private Integer rpType;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}