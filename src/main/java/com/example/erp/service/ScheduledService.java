package com.example.erp.service;

import com.example.erp.entity.*;
import com.example.erp.mapper.AdjustSalaryMapper;
import com.example.erp.mapper.EmployeeRpMapper;
import com.example.erp.mapper.LeaveMapper;
import com.example.erp.mapper.SalaryDetailsMapper;
import com.example.erp.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author qzp
 * @date 2020/5/11
 */
@Service
public class ScheduledService {
    @Autowired
    private SalaryDetailsMapper salaryDetailsMapper;
    @Autowired
    private AdjustSalaryMapper adjustSalaryMapper;
    @Autowired
    private LeaveMapper leaveMapper;
    @Autowired
    private EmployeeRpMapper employeeRpMapper;
    @Autowired
    private EmailService emailService;

    /*每月五号发放工资*/
    @Scheduled(cron = "0 0 0 5 * ?")
    public void wagesCount(){
        Date date = new Date();
        List<SalaryDetails> salaryDetails = salaryDetailsMapper.getAllEmpSal();
        if (salaryDetails.size() == 0) {
            return;
        }
        List<AdjustSalary> adjustSalaries = adjustSalaryMapper.getEmpNewAdjustRecord();
        adjustBasic(salaryDetails,adjustSalaries);
        Date beginDate = DateUtils.getMonthBegin(DateUtils.getLastMonth(date));
        Date endDate = DateUtils.getMonthEnd(DateUtils.getLastMonth(date));
        List<Leave> leaves = leaveMapper.getLeaveByDateScope(beginDate,endDate);
        initLeaveCount(salaryDetails,leaves);
        List<EmployeeRp> employeeRps = employeeRpMapper.getEmpRpByDateScope(beginDate,endDate);
        initRewordAndPunish(salaryDetails,employeeRps);
        /*计算应发总工资*/
        countTotal(salaryDetails);
        /*电子邮件发送工资单到员工邮箱*/
        emailService.sendEmpSalaryEmail(salaryDetails);
        /*将员工工资单写入到数据库*/
        salaryDetailsMapper.multiInsert(salaryDetails);
    }


    private void countTotal(List<SalaryDetails> salaryDetails) {
        Date date = new Date();
        for (SalaryDetails salaryDetail : salaryDetails) {
            double countMoney = salaryDetail.getBasicPay();
            Salary salary = salaryDetail.getSalary();
            countMoney += salary.getBonus() + salary.getLunchSalary() + salary.getTrafficSalary();
            countMoney += salary.getMedicalBase() * salary.getMedicalPer() + salary.getAccumulationFundBase() * salary.getAccumulationFundBase() + salary.getPensionBase() * salary.getPensionPer();
            countMoney += salaryDetail.getLeaveCount() + salaryDetail.getReward() + salaryDetail.getPunishes();
            salaryDetail.setPaidWages(countMoney);
            salaryDetail.setDispenseDate(date);
        }
    }

    /*奖罚金额计算*/
    private void initRewordAndPunish(List<SalaryDetails> salaryDetails, List<EmployeeRp> employeeRps) {
        for (EmployeeRp employeeRp : employeeRps) {
            salaryDetails.forEach(salaryDetail -> {
                int reword = salaryDetail.getReward();
                int punish = salaryDetail.getPunishes();
                if (employeeRp.getEid().equals(salaryDetail.getEmployee().getId())){
                    if (employeeRp.getRpType() == 0){
                        reword += employeeRp.getRpPoint() * 20;
                        salaryDetail.setReward(reword);
                    }else {
                        punish += employeeRp.getRpPoint() * 20;
                        salaryDetail.setPunishes(punish);
                    }
                }
            });
        }
    }

    /*初始化请假扣除金额*/
    private void initLeaveCount(List<SalaryDetails> salaryDetails, List<Leave> leaves) {
        for (Leave leave : leaves) {
            salaryDetails.forEach(salaryDetail -> {
                if (leave.getEid().equals(salaryDetail.getEmployee().getId())){
                    /*请假天数*/
                    int day = DateUtils.daysBetween(leave.getBegin(),leave.getEnd());
                    Integer leaveCount = salaryDetail.getLeaveCount();
                    leaveCount += leave.getType() == 0? day*100:day*50;
                    salaryDetail.setLeaveCount(leaveCount);
                }
            });
        }
    }

    /*初始化基本工资*/
    private void adjustBasic(List<SalaryDetails> salaryDetails, List<AdjustSalary> adjustSalaries) {
        for (AdjustSalary adjustSalary : adjustSalaries) {
            salaryDetails.forEach(salaryDetail -> {
                if (adjustSalary.getEid().equals(salaryDetail.getEmployee().getId())){
                    salaryDetail.setBasicPay(adjustSalary.getAfterSalary());
                }else {
                    salaryDetail.setBasicPay(salaryDetail.getSalary().getBasicSalary());
                }
            });
        }
    }

}
