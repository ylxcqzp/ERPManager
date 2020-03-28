package com.example.erp.controller;

import com.example.erp.entity.Employee;
import com.example.erp.entity.EmployeeRp;
import com.example.erp.entity.RespMes;
import com.example.erp.entity.RespPageBean;
import com.example.erp.service.EmployeeRpService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author qzp
 * @date 2020/3/27
 */
@RestController
@RequestMapping("/employee/empRp")
public class EmployeeRpController {
    @Autowired
    private EmployeeRpService employeeRpService;

    @GetMapping(value = "/")
    public RespPageBean getEmployeeRps(String keyword,
                                       @RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "10") Integer size,
                                       @RequestParam(defaultValue = "rpDate") String orderName,
                                       @RequestParam(defaultValue = "asc") String orderBy) {
        return employeeRpService.getEmployeeRps(keyword,page,size,orderName,orderBy);
    }

    @DeleteMapping("/delete/{id}")
    public RespMes deleteEmpRp(@PathVariable Integer id){
        try {
            employeeRpService.deleteEmpRp(id);
        }catch (Exception e){
            e.printStackTrace();
            return RespMes.error("删除失败！");
        }
        return RespMes.ok("更新成功");
    }

    @PostMapping("/add")
    public RespMes addEmpRp(@RequestBody EmployeeRp employeeRp){

        System.out.println(employeeRp);
        employeeRp.setRpDate(new Date());
        return employeeRpService.addEmpRp(employeeRp);
    }
}
