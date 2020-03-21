package com.example.erp.mapper;

import com.example.erp.entity.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    List<Salary> findAll();
}