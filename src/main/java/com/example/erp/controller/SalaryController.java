package com.example.erp.controller;

import com.example.erp.entity.RespMes;
import com.example.erp.entity.Salary;
import com.example.erp.service.SalaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qzp
 * @date 2020/3/12
 */
@Slf4j
@RestController
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @RequestMapping("/all")
    public List<Salary> getAll(){
        return salaryService.getAllSalaries();
    }

    @PostMapping("/update")
    public RespMes addSalary(@RequestBody Salary salary){
        if (salaryService.addSalary(salary)){
            return RespMes.ok("添加成功");
        }
        return RespMes.error("添加失败");
    }

    @PutMapping("/update")
    public RespMes updateSalary(@RequestBody Salary salary){
        if (salaryService.updateSalary(salary)){
            return RespMes.ok("更新成功");
        }
        return RespMes.error("更新失败");
    }

    @DeleteMapping("/update/{id}")
    public RespMes delete(@PathVariable Integer id){
        if (salaryService.deleteSalary(id)){
            return RespMes.ok("删除成功");
        }
        return RespMes.error("删除失败");
    }

}
