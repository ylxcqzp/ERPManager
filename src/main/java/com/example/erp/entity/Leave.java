package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工请假表
 * @author 
 */
@Data
public class Leave implements Serializable {
    private Integer id;

    private Employee employee;

    /**
     * 请假原因
     */
    private String reason;

    /**
     * 请假开始时间
     */
    private Date begin;

    /**
     * 请假结束时间
     */
    private Date end;

    /**
     * 批准的hr
     */
    private Hr hr;

    /**
     * 是否批准（0，未处理；1，同意，2，拒绝）
     */
    private Short status;

    private static final long serialVersionUID = 1L;

}