package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 考评表
 * @author 
 */
@Data
public class Appraise implements Serializable {
    private Integer id;

    private Employee employee;

    /**
     * 考评日期
     */
    private Date appDate;

    /**
     * 考评结果
     */
    private String appResult;

    /**
     * 考评内容
     */
    private String appContent;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

}