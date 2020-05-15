package com.example.erp.mapper;

import com.example.erp.entity.Employee;
import com.example.erp.entity.SalaryDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SalaryDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SalaryDetails record);

    int insertSelective(SalaryDetails record);

    SalaryDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SalaryDetails record);

    int updateByPrimaryKey(SalaryDetails record);

    List<SalaryDetails> selectByOptions(@Param("emp") Employee employee,@Param("beginDate") Date beginDate, @Param("endDate")Date endDate);

    List<SalaryDetails> getAllEmpSal();

    void multiInsert(@Param("salaryDetails") List<SalaryDetails> salaryDetails);
}