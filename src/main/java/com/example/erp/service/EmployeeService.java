package com.example.erp.service;

import com.example.erp.entity.Employee;
import com.example.erp.entity.RespPageBean;
import com.example.erp.mapper.EmployeeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.crypto.Data;
import java.util.List;

/**
 * @author qzp
 * @date 2020/2/23
 */
@Slf4j
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    public RespPageBean getEmployees(Employee employee, Data[] beginDateScope,
                                     Integer page,Integer size){
        Page<Employee> employeePage = PageHelper.startPage(page, size);
        List<Employee> employees = employeeMapper.selectByOptions(employee,beginDateScope);
        RespPageBean pageBean = new RespPageBean();
        pageBean.setTotal(employeePage.getTotal());
        pageBean.setData(employees);
        return pageBean;
    }
}
