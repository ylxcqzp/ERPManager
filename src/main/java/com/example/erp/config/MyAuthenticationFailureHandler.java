package com.example.erp.config;

import com.example.erp.entity.RespMes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author qzp
 * @date 2020/2/15
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        RespMes mes = RespMes.error("登录失败");
        if (e instanceof LockedException) {
            mes.setMsg("账户被锁定，请联系管理员!");
        } else if (e instanceof CredentialsExpiredException) {
            mes.setMsg("密码过期，请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
            mes.setMsg("账户过期，请联系管理员!");
        } else if (e instanceof DisabledException) {
            mes.setMsg("账户被禁用，请联系管理员!");
        } else if (e instanceof BadCredentialsException) {
            mes.setMsg("用户名或者密码输入错误，请重新输入!");
        }
        String s = new ObjectMapper().writeValueAsString(mes);
        out.write(s);
        out.flush();
        out.close();
    }
}
