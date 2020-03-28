package com.example.erp.controller;

import com.example.erp.entity.RespMes;
import com.example.erp.entity.RespPageBean;
import com.example.erp.service.LeaveService;
import com.example.erp.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author qzp
 * @date 2020/3/26
 */
@RestController
@RequestMapping("/employee/leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @RequestMapping("/")
    public RespPageBean getAllLeaves(String keyword,
                                     @RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "10") Integer size) {
        return leaveService.getAllLeave(keyword,page,size);
    }

    @RequestMapping("/currentMonth")
    public RespPageBean getLeavesWithMonth(){
        Date date = new Date();
        Date begin = DateUtils.getMonthBegin(date);
        Date end = DateUtils.getMonthEnd(date);
        System.out.println(end);
        return leaveService.getLeaveWithMonth(begin,end);
    }

    @RequestMapping("/status/")
    public RespMes updateStatus(@RequestParam Integer id,@RequestParam Integer status){
        try {
            leaveService.updateStatus(id,status);
        }catch (Exception e){
            e.printStackTrace();
            return RespMes.error("更新状态失败");
        }
        return RespMes.ok("状态已处理");
    }
}
