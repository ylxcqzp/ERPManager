package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 民族
 * @author 
 */
@Data
public class Nation implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}