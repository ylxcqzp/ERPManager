package com.example.erp.controller;

import com.example.erp.constant.Constant;
import com.example.erp.entity.*;
import com.example.erp.service.*;
import com.example.erp.util.ExcelForEmpUtils;
import com.example.erp.util.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private NationService nationService;
    @Autowired
    private JobLevelService jobLevelService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private PoliticsStatusService politicsStatusService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public RespPageBean getAllEmployees(Employee employee,
                                        Date[] beginDateScope,
                                        @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size){
        return employeeService.getEmployees(employee,beginDateScope,page,size);
    }

    @PostMapping("/add")
    public RespMes addEmp(@RequestBody Employee employee){
        if (employeeService.addEmp(employee)){
            return RespMes.ok("添加成功！");
        }
        return RespMes.error("添加失败！");
    }

    @PutMapping("/update")
    public RespMes updateEmp(@RequestBody Employee employee){
        if (employeeService.updateEmp(employee)){
            return RespMes.ok("更新成功");
        }
        return RespMes.error("更新失败");
    }

    @DeleteMapping("/delete/{id}")
    public RespMes deleteEmp(@PathVariable Integer id){
        if (employeeService.delete(id)){
            return RespMes.ok("删除成功");
        }
        return RespMes.error("删除失败");
    }

    @RequestMapping("/nextWorkId")
    public RespMes getNextId(){
        Long maxWorkId = employeeService.getNextWorkId();
        return RespMes.build().setStatus(200).setObj(String.format("%08d",maxWorkId+1));
    }

    @GetMapping("/exportData")
    public ResponseEntity<byte[]> getExcel(HttpServletRequest request, HttpServletResponse response){
        List<Employee> employees = employeeService.getAllEmp();
        return ExcelForEmpUtils.employee2Excel(employees);
    }

    @PostMapping("/import")
    public RespMes importData(MultipartFile file){
        List<Employee> employees = ExcelForEmpUtils.excel2Employee(file, nationService.getAllNations(), politicsStatusService.geAllPoliticsStatus(), departmentService.getAllDeps(), positionService.getAllPositions(), jobLevelService.getAllJobLevels());
        try {
            employeeService.multiInsert(employees);
        }catch (Exception e){
            return RespMes.error("上传失败");
        }
        return RespMes.ok("上传成功");
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations(){
        return nationService.getAllNations();
    }

    @GetMapping("/jobLevels")
    public List<JobLevel> getAllJobLevels(){
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }

    @GetMapping("/politicsStatus")
    public List<PoliticsStatus> getAllPoliticsStatus(){
        return politicsStatusService.geAllPoliticsStatus();
    }

    @GetMapping("/allDeps")
    public List<Department> getAllDeps(){
        return departmentService.getAllDeps();
    }
}
