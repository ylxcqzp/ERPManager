package com.example.erp.controller;

import com.example.erp.entity.DTO.DepartmentCountDTO;
import com.example.erp.entity.DTO.EmpAgeDTO;
import com.example.erp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qzp
 * @date 2020/5/13
 */
@RestController
@RequestMapping("/statistics/record")
public class StatisticsRecordController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/dep_count")
    public List<DepartmentCountDTO> getDepCount() {
        return employeeService.getDepCount();
    }

    @RequestMapping("/emp_age")
    public List<EmpAgeDTO> getEmpAgeCount(){
        return employeeService.getEmpAgeCount();
    }

}
