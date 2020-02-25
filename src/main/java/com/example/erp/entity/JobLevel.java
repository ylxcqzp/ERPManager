package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * jobLevel 职称
 * @author 
 */
@Data
public class JobLevel implements Serializable {
    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    private String titleLevel;

    private Date createDate;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;

}