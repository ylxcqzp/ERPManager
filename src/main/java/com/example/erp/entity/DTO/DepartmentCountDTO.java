package com.example.erp.entity.DTO;

import lombok.Data;

/**
 * @author qzp
 * @date 2020/5/13
 */
@Data
public class DepartmentCountDTO {
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 部门人数
     */
    private Integer count;
}
