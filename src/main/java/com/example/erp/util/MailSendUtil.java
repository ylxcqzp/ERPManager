package com.example.erp.util;

import com.example.erp.entity.SalaryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author qzp
 * @date 2020/5/15
 */
@Component
public class MailSendUtil {
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Autowired
    private TemplateEngine templateEngine;

    public void sendSalaryMail(SalaryDetails details) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper help = new MimeMessageHelper(mimeMessage, true);
            help.setSubject("本月工资单");
            help.setFrom("2296253727@qq.com");
            help.setTo(details.getEmployee().getEmail());
            /*添加正文*/
            Context context = new Context();
            context.setVariable("empName","职工：" + details.getEmployee().getName());
            context.setVariable("name",details.getEmployee().getName());
            context.setVariable("depName",details.getEmployee().getDepartment().getName());
            context.setVariable("position",details.getEmployee().getPosition().getName());
            context.setVariable("basicPay",details.getBasicPay());
            context.setVariable("bonus",details.getSalary().getBonus());
            context.setVariable("lunchSalary",details.getSalary().getLunchSalary());
            context.setVariable("trafficSalary",details.getSalary().getTrafficSalary());
            context.setVariable("pensionMoney",details.getSalary().getPensionBase()*details.getSalary().getPensionPer());
            context.setVariable("medicalMoney",details.getSalary().getMedicalBase()*details.getSalary().getMedicalPer());
            context.setVariable("accumulationFundMoney",details.getSalary().getAccumulationFundBase()*details.getSalary().getAccumulationFundPer());
            context.setVariable("leaveCount",details.getLeaveCount());
            context.setVariable("reward",details.getReward());
            context.setVariable("punishes",details.getPunishes());
            context.setVariable("paidWages",details.getPaidWages());
            String content = templateEngine.process("salary_email", context);
            help.setText(content,true);
            mailSender.send(mimeMessage);
        }catch (MessagingException e){
            e.printStackTrace();
        }
    }
}
