package com.example.erp.exception;

import com.example.erp.entity.RespMes;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author qzp
 * @date 2020/2/18
 */
@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(SQLException.class)
    public RespMes sqlException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return RespMes.error("该数据有关联数据，操作失败!");
        }
        return RespMes.error("数据库异常，操作失败!");
    }
}
