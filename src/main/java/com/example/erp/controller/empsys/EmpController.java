package com.example.erp.controller.empsys;

import com.example.erp.entity.Leave;
import com.example.erp.entity.RespMes;
import com.example.erp.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qzp
 * @date 2020/4/14
 */
@RestController
@RequestMapping("/emp_sys")
public class EmpController {
    @Autowired
    private LeaveService leaveService;

    @RequestMapping("/")
    public RespMes testEmp(){
        return RespMes.ok("连接成功","无验证模式");
    }

    @PostMapping("/leave")
    public RespMes addLeave(@RequestBody Leave leave) {
        return leaveService.addLeave(leave);
    }

    @GetMapping("/leave/{eid}")
    public List<Leave> getLeavesByEid(@PathVariable("eid")Integer eid){
        return leaveService.getLeavesByEid(eid);
    }
}
