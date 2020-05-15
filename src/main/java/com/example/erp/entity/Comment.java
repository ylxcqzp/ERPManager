package com.example.erp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * comment 评论表
 * @author 
 */
@Data
public class Comment implements Serializable {
    private Integer id;

    private Employee employee;

    private Integer mid;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date createDate;


}