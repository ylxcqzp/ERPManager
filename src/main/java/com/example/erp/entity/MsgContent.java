package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息
 * @author 
 */
@Data
public class MsgContent implements Serializable {
    private Integer id;

    private String title;

    private String message;

    private Hr hr;

    private Date createDate;

    private static final long serialVersionUID = 1L;

}