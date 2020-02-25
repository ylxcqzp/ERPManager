package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 调薪表
 * @author 
 */
@Data
public class AdjustSalary implements Serializable {
    private Integer id;

    private Employee employee;

    /**
     * 调薪日期
     */
    private Date date;

    /**
     * 调前薪资
     */
    private Integer beforeSalary;

    /**
     * 调后薪资
     */
    private Integer afterSalary;

    /**
     * 调薪原因
     */
    private String reason;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

}