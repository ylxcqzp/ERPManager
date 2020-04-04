package com.example.erp.service;

import com.example.erp.entity.RespMes;
import com.example.erp.entity.Salary;
import com.example.erp.mapper.AdjustSalaryMapper;
import com.example.erp.mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author qzp
 * @date 2020/3/12
 */
@Service
public class SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;
    @Autowired
    private AdjustSalaryMapper adjustSalaryMapper;

    public List<Salary> getAllSalaries() {
        return salaryMapper.findAll();
    }

    @Transactional
    public boolean addSalary(Salary salary) {
        try {
            salary.setCreateDate(new Date());
            salaryMapper.insertSelective(salary);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional
    public boolean updateSalary(Salary salary) {
        try {
            salary.setCreateDate(new Date());
            salaryMapper.updateByPrimaryKeySelective(salary);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional
    public boolean deleteSalary(Integer id) {
        try {
            salaryMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public RespMes getSalaryByEid(Integer eid) {
        Salary salary = salaryMapper.findByEid(eid);
        return RespMes.ok("",salary);
    }

}
