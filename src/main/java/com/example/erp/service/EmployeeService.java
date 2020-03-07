package com.example.erp.service;

import com.example.erp.entity.Employee;
import com.example.erp.entity.RespPageBean;
import com.example.erp.mapper.EmployeeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author qzp
 * @date 2020/2/23
 */
@Slf4j
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");


    public RespPageBean getEmployees(Employee employee, Date[] beginDateScope,
                                     Integer page,Integer size){
        Page<Employee> employeePage = PageHelper.startPage(page, size);
        List<Employee> employees = employeeMapper.selectByOptions(employee,beginDateScope);
        RespPageBean pageBean = new RespPageBean();
        pageBean.setTotal(employeePage.getTotal());
        pageBean.setData(employees);
        return pageBean;
    }

    public Long getNextWorkId() {
        return employeeMapper.nextWorkId();
    }

    public boolean addEmp(Employee employee) {
        employee.setPassword("123456");
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 + (Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month/12)));
        try {
            employeeMapper.insertSelective(employee);
        }catch (Exception e){
            log.error("数据插入异常",e);
            return false;
        }
        return true;
    }

    public boolean updateEmp(Employee employee) {
        try {
            employeeMapper.updateByPrimaryKeySelective(employee);
        }catch (Exception e){
            log.error("数据库操作失败:"+e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(Integer id) {
        try {
            employeeMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error("数据库操作失败："+e.getMessage());
            return false;
        }
        return true;
    }
}
