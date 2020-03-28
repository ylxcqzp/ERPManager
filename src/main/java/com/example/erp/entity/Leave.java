package com.example.erp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * leave
 * @author 
 */
@Data
public class Leave implements Serializable {
    private Integer id;

    private Employee employee;

    /**
     * 请假原因
     */
    private String reason;

    /**
     * 请假开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date begin;

    /**
     * 请假结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date end;

    /**
     * 批准的hr
     */
    private Hr hr;

    /**
     * 是否批准（0，未处理；1，同意，2，拒绝）
     */
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date handleDate;

}