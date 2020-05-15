package com.example.erp.mapper;

import com.example.erp.entity.AdjustSalary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdjustSalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdjustSalary record);

    int insertSelective(AdjustSalary record);

    AdjustSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdjustSalary record);

    int updateByPrimaryKey(AdjustSalary record);

    List<AdjustSalary> getAdjustSalaryByCondition(@Param("keyword") String keyword,@Param("orderName") String orderName, @Param("orderBy") String orderBy);

    AdjustSalary getByEid(@Param("eid") Integer eid);

    List<AdjustSalary> getEmpNewAdjustRecord();
}