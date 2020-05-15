package com.example.erp.service;

import com.example.erp.entity.SalaryDetails;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qzp
 * @date 2020/5/11
 */
@Service
public class EmailService {

    @Async
    public void sendEmpSalaryEmail(List<SalaryDetails> salaryDetails){

    }
}
