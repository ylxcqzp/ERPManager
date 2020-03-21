package com.example.erp.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * jobLevel 职称
 * @author 
 */
@Data
@Accessors(chain = true)
public class JobLevel implements Serializable {
    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    private String titleLevel;

    private Date createDate;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobLevel jobLevel = (JobLevel) o;
        return name.equals(jobLevel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}