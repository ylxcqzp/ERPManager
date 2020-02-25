package com.example.erp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qzp
 * @date 2020/2/15
 */

@Data
public class Meta implements Serializable {
    private boolean keepAlive;
    private boolean requireAuth;
}
