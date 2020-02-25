package com.example.erp.config;

import com.example.erp.entity.Hr;
import com.example.erp.entity.RespMes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
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
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Hr hr = (Hr)authentication.getPrincipal();
        /*清除密码信息*/
        hr.setPassword(null);
        RespMes mes = RespMes.ok("登入成功",hr);
        String s = new ObjectMapper().writeValueAsString(mes);
        out.write(s);
        out.flush();
        out.close();
    }
}
