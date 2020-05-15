package com.example.erp.controller;

import com.example.erp.entity.Department;
import com.example.erp.entity.Employee;
import com.example.erp.entity.Position;
import com.example.erp.entity.RespPageBean;
import com.example.erp.service.DepartmentService;
import com.example.erp.service.PositionService;
import com.example.erp.service.SalaryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author qzp
 * @date 2020/5/10
 */
@RestController
@RequestMapping("/salary/details")
public class SalaryDetailsController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private SalaryDetailsService salaryDetailsService;

    @RequestMapping("/positions")
    public List<Position> getPositions() {
        return positionService.getAllPositions();
    }

    @RequestMapping("/all_deps")
    public List<Department> getAllDeps() {
        return departmentService.getAllDeps();
    }

    @RequestMapping("/")
    public RespPageBean getSalaryDetails(Employee employee,
                                         Date begin,
                                         Date end,
                                         @RequestParam(defaultValue = "1") Integer page,
                                         @RequestParam(defaultValue = "10") Integer size){
        return salaryDetailsService.getSalaryDetails(employee,begin,end,page,size);
    }
}
