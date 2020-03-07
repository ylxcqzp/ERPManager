package com.example.erp.mapper;

import com.example.erp.entity.EmployeeRp;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeRp record);

    int insertSelective(EmployeeRp record);

    EmployeeRp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeRp record);

    int updateByPrimaryKey(EmployeeRp record);
}