package com.example.erp.controller;

import com.example.erp.entity.Employee;
import com.example.erp.entity.RespPageBean;
import com.example.erp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * @author qzp
 * @date 2020/2/20
 */
@Slf4j
@RestController
@RequestMapping(value = "/employee/basic")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public RespPageBean getAllEmployees(Employee employee,
                                        Data[] beginDateScope,
                                        @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size){
        System.out.println(employee);
        return employeeService.getEmployees(employee,beginDateScope,page,size);
    }
}
