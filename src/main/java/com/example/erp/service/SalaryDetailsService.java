package com.example.erp.service;

import com.example.erp.entity.Employee;
import com.example.erp.entity.RespPageBean;
import com.example.erp.entity.SalaryDetails;
import com.example.erp.mapper.SalaryDetailsMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author qzp
 * @date 2020/5/10
 */
@Service
public class SalaryDetailsService {
    @Autowired
    private SalaryDetailsMapper salaryDetailsMapper;

    public RespPageBean getSalaryDetails(Employee employee,
                                         Date beginDate, Date endDate,
                                         Integer page,Integer size) {
        Page<SalaryDetails> salDetailsPages = PageHelper.startPage(page, size);
        List<SalaryDetails> salaryDetails = salaryDetailsMapper.selectByOptions(employee,beginDate,endDate);
        RespPageBean pageBean = new RespPageBean();
        pageBean.setTotal(salDetailsPages.getTotal());
        pageBean.setData(salaryDetails);
        return pageBean;
    }

    public List<SalaryDetails> getSalaryDetailsByIds(Integer [] ids) {
        if (ids.length == 0){
            return null;
        }
        return salaryDetailsMapper.selectByIds(ids);
    }
}
