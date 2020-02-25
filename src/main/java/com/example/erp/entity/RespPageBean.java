package com.example.erp.entity;

import lombok.Data;

import java.util.List;

/**
 * @author qzp
 * @date 2020/2/24
 */
@Data
public class RespPageBean {
    private Long total;
    private List<?> data;
}
