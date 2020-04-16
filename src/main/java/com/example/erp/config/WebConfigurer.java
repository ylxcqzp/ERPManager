package com.example.erp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author qzp
 * @date 2020/4/14
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer{
    @Autowired
    private TokenHeaderInterceptor tokenHeaderInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenHeaderInterceptor).addPathPatterns("/emp/**");
    }

}
