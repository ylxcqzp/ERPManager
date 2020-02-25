package com.example.erp.entity;

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

    private Integer eid;

    private Integer mid;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 评论时间
     */
    private Date createDate;

    private static final long serialVersionUID = 1L;

}