package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * empRemove
 * @author 
 */
@Data
public class EmpRemove{
    private Integer id;

    private Employee employee;

    /**
     * 调动后部门
     */
    private Integer afterDepartment;

    /**
     * 调动后职位
     */
    private Integer afterPosition;

    /**
     * 调动日期
     */
    private Date removeDate;

    /**
     * 调动原因
     */
    private String reason;

    private String remark;

}