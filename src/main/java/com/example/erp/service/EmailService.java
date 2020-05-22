package com.example.erp.service;

import com.example.erp.entity.SalaryDetails;
import com.example.erp.util.MailSendUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qzp
 * @date 2020/5/11
 */
@Service
public class EmailService {
    @Autowired
    private MailSendUtil mailSendUtil;

    @Async
    public void sendEmpSalaryEmail(List<SalaryDetails> salaryDetails){
        for (SalaryDetails salaryDetail : salaryDetails) {
            mailSendUtil.sendSalaryMail(salaryDetail);
        }
    }
}
