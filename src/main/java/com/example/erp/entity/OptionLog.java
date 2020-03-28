package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * optionLog
 * @author 
 */
@Data
public class OptionLog {
    private Integer id;

    /**
     * 添加日期
     */
    private Date addDate;

    /**
     * 操作内容
     */
    private String operate;

    /**
     * 操作员ID
     */
    private Hr hr;

}