package com.example.erp.util;

import com.example.erp.entity.Hr;
import com.example.erp.entity.OptionLog;
import com.example.erp.mapper.EmployeeRpMapper;
import com.example.erp.mapper.OptionLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

/**
 * @author qzp
 * @date 2020/3/27
 */
public class OptionLogRecord {
    @Autowired
    private static OptionLogMapper optionLogMapper;
    public static void recordLog(String context) {
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        OptionLog optionLog = new OptionLog();
        optionLog.setAddDate(new Date());
        optionLog.setOperate(context);
        optionLog.setHr(hr);
        optionLogMapper.insertSelective(optionLog);
    }
}
