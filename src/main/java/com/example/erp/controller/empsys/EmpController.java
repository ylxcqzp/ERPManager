package com.example.erp.controller.empsys;

import com.example.erp.entity.RespMes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qzp
 * @date 2020/4/14
 */
@RestController
@RequestMapping("/emp_sys")
public class EmpController {

    @RequestMapping("/")
    public RespMes testEmp(){
        return RespMes.ok("连接成功","无验证模式");
    }
}
