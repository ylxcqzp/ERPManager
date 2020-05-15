package com.example.erp.config;

import com.example.erp.entity.RespMes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author qzp
 * @date 2020/2/15
 *
 * 自定义未登录时，返回状态码401
 */
@Component
public class UrlAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
        String token = req.getHeader("accessToken");
        resp.setContentType("application/json;charset=utf-8");
        if (token != null){
            resp.setStatus(504);
        }else {
            resp.setStatus(401);
        }
        PrintWriter out = resp.getWriter();
        RespMes mes = RespMes.error("请求失败");
        if (e instanceof InsufficientAuthenticationException) {
            mes.setMsg("请求失败，请联系管理员!");
        }
        out.write(new ObjectMapper().writeValueAsString(mes));
        out.flush();
        out.close();
    }
}
