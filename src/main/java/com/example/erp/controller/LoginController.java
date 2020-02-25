package com.example.erp.controller;


import com.example.erp.entity.Hr;
import com.example.erp.entity.RespMes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qzp
 */
@RestController
public class LoginController {
    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    public RespMes login(Hr user){
        return RespMes.ok("登入成功");
    }
}
