package com.example.erp.config;

import com.example.erp.entity.RespMes;
import com.example.erp.util.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author qzp
 * @date 2020/4/14
 */
@Component
public class TokenHeaderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("accessToken");
        /*未找到token*/
        if (token != null) {
            boolean result = JwtTokenUtil.verify(token);
            if (result){
                return true;
            }
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        RespMes message = RespMes.error("未登入，请先登入");
        String s = new ObjectMapper().writeValueAsString(message);
        out.write(s);
        out.flush();
        out.close();
        return false;
    }
}
