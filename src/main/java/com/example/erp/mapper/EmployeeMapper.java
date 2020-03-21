package com.example.erp.mapper;

import com.example.erp.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> selectAll();

    List<Employee> selectByOptions(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long nextWorkId();

    void multiInsert(@Param("list") List<Employee> employees);
}