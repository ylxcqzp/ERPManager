package com.example.erp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author qzp
 * @date 2020/2/17
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 配置swagger docket的实例
     * @return
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.erp.controller"))
                .build();
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("ghost","","2296253727@qq.com");
        return new ApiInfo(
                "ERP管理系统API",
                "单身狗也是狗",
                "v1.0",
                "",
                contact,"Apache2.0",
                "",
                new ArrayList<>());
    }
}
