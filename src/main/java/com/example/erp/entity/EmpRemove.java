package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工调动表
 * @author 
 */
@Data
public class EmpRemove implements Serializable {
    private Integer id;

    private Employee employee;

    /**
     * 调动后部门
     */
    private Integer afterdepid;

    /**
     * 调动后职位
     */
    private Integer afterjobid;

    /**
     * 调动日期
     */
    private Date removeDate;

    /**
     * 调动原因
     */
    private String reason;

    private String remark;

    private static final long serialVersionUID = 1L;

}