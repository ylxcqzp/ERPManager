package com.example.erp.controller;

import com.example.erp.entity.RespMes;
import com.example.erp.entity.RespPageBean;
import com.example.erp.entity.Salary;
import com.example.erp.service.EmployeeService;
import com.example.erp.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qzp
 * @date 2020/3/24
 */
@RestController
@RequestMapping("/salary/config")
public class SalaryConfigController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SalaryService salaryService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public RespPageBean getEmployeeWithSal(
                                    String keyword,
                                    @RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size){
        return employeeService.getEmpsWithSal(keyword,page,size);
    }

    @RequestMapping(value = "/salaries",method = RequestMethod.GET)
    public List<Salary> getAllSalary() {
        return salaryService.getAllSalaries();
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public RespMes updateEmpSal(Integer eid, Integer sid) {
        return employeeService.updateEmpSalByEid(eid,sid);
    }
}
