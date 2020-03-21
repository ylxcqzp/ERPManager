package com.example.erp.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * position 职位信息
 * @author 
 */
@Accessors(chain = true)
@Data
public class Position implements Serializable {
    private Integer id;

    /**
     * 职位
     */
    private String name;

    private Date createDate;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(name, position.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createDate, enabled);
    }
}