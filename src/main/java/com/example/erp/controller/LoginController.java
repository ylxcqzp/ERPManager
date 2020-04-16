package com.example.erp.controller;


import com.example.erp.entity.*;
import com.example.erp.service.EmployeeService;
import com.example.erp.util.JwtTokenUtil;
import com.example.erp.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qzp
 */
@RestController
public class LoginController {
    private static final long TIME_OUT = 60*60*24*7;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/empLogin")
    public RespMes doLogin(Employee emp){
        String workId = emp.getWorkId();
        String password = emp.getPassword();
        Employee employee = employeeService.getEmployeeByWorkId(workId);
        if (employee != null && password.equals(employee.getPassword())){
            String token = JwtTokenUtil.sign(workId, String.valueOf(employee.getId()));
            if (token != null){
                employee.setPassword("");
                redisUtil.set(token,employee);
                redisUtil.expire(token,TIME_OUT);
                Map<String,Object> retData = new HashMap<>();
                retData.put("user",employee);
                retData.put("token",token);
                return RespMes.ok("登入成功",retData);
            }
        }
        HashMap<String, Object> retData = new HashMap<>();
        retData.put("user","");
        retData.put("token","");
        return RespMes.ok("登录失败",retData);
    }
}
