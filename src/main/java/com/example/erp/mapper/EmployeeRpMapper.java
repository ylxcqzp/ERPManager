package com.example.erp.mapper;

import com.example.erp.entity.EmployeeRp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeRp record);

    int insertSelective(EmployeeRp record);

    EmployeeRp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeRp record);

    int updateByPrimaryKey(EmployeeRp record);

    List<EmployeeRp> getEmpRpsByCondition(@Param("keyword") String keyword,@Param("orderName") String orderName,@Param("orderBy") String orderBy);

    List<EmployeeRp> getEmpRpByDateScope(@Param("beginDate") Date beginDate,@Param("endDate") Date endDate);
}