package com.example.erp.controller;

import com.example.erp.entity.*;
import com.example.erp.service.DepartmentService;
import com.example.erp.service.EmpRemoveService;
import com.example.erp.service.EmployeeService;
import com.example.erp.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qzp
 * @date 2020/4/3
 */
@RestController
@RequestMapping(value = "/employee/emp_rm")
public class EmpRemoveController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmpRemoveService empRemoveService;

    @GetMapping("/emp_info/{workId}")
    public RespMes getEmpInfo(@PathVariable(value = "workId") String workId){
        Employee employee = employeeService.getEmpByWorkId(workId);
        return employee == null?RespMes.error("该员工不存在，请重新输入！"):RespMes.ok("",employee);
    }
    @PostMapping("/add_emp_rm")
    public RespMes addEmpRemove(@RequestBody EmpRemove empRemove) {
        return empRemoveService.addEmpRemove(empRemove);
    }

    @GetMapping("/all_deps")
    public List<Department> getAllDeps(){
        return departmentService.getAllDeps();
    }

    @GetMapping("/positions")
    public List<Position> getPositions() {
        return positionService.getAllPositions();
    }
}
