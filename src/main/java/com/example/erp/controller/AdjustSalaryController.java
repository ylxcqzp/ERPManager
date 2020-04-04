package com.example.erp.controller;

import com.example.erp.entity.AdjustSalary;
import com.example.erp.entity.RespMes;
import com.example.erp.entity.RespPageBean;
import com.example.erp.service.AdjustSalaryService;
import com.example.erp.service.EmployeeService;
import com.example.erp.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author qzp
 * @date 2020/4/1
 */
@RestController
@RequestMapping(value = "/employee/sal_adjust")
public class AdjustSalaryController {
    @Autowired
    private AdjustSalaryService adjustSalaryService;
    @Autowired
    private SalaryService salaryService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/")
    public RespPageBean getAdjustSalaries(String keyword,
                                          @RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer size,
                                          @RequestParam(defaultValue = "date") String orderName,
                                          @RequestParam(defaultValue = "desc") String orderBy) {
        return adjustSalaryService.getAdjustSalaries(keyword,page,size,orderBy,orderName);
    }

    @GetMapping(value = "/salary/{eid}")
    public RespMes getSalary(@PathVariable(value = "eid") Integer eid) {
        return salaryService.getSalaryByEid(eid);
    }

    @GetMapping(value = "/single/{workId}")
    public RespMes getSalaryAdjust(@PathVariable(value = "workId") String workId){
        Integer eid = employeeService.getEmpIdByWorkId(workId);
        if (eid == null) {
            return RespMes.error("该员工不存在，请重新输入");
        }
        return adjustSalaryService.getByEid(eid);
    }


    @PostMapping(value = "/add_sal_adjust")
    public RespMes addSalAdjust(@RequestBody AdjustSalary adjustSalary){
        adjustSalary.setDate(new Date());
        return adjustSalaryService.addSalAdjust(adjustSalary);
    }
}
