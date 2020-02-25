package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * department 部门
 * @author 
 */
@Data
public class Department implements Serializable {
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    private Integer parentId;

    private String depPath;

    private Boolean enabled;

    private Boolean isParent;

    private List<Department> children = new ArrayList<>();

    private static final long serialVersionUID = 1L;

}