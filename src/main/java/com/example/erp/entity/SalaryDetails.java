package com.example.erp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * salary_details
 * @author 
 */

@Data
public class SalaryDetails {
    private Integer id;

    private Employee employee;

    private Salary salary;

    /**
     * 应发工资
     */
    private Integer basicPay;

    /**
     * 请假扣除
     */
    private Integer leaveCount = 0;

    /**
     * 当月奖励金额
     */
    private Integer reward = 0;

    /**
     * 当月处罚扣款
     */
    private Integer punishes = 0;

    /**
     * 实发工资
     */
    private Double paidWages;

    /**
     * 发放时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date dispenseDate;

}