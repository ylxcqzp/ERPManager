package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * role
 * @author 
 */
@Data
public class Role implements Serializable {
    private Integer id;

    private String name;

    /**
     * 角色名称
     */
    private String nameZh;

    private static final long serialVersionUID = 1L;

}