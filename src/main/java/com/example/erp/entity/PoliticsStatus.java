package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 政党
 * @author 
 */
@Data
public class PoliticsStatus implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;

}