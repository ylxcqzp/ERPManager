package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * position 职位信息
 * @author 
 */
@Data
public class Position implements Serializable {
    private Integer id;

    /**
     * 职位
     */
    private String name;

    private Date createDate;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;
}