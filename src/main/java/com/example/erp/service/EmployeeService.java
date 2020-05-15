package com.example.erp.service;

import com.example.erp.entity.DTO.DepartmentCountDTO;
import com.example.erp.entity.DTO.EmpAgeDTO;
import com.example.erp.entity.DTO.EmpAgeTempDTO;
import com.example.erp.entity.Employee;
import com.example.erp.entity.RespMes;
import com.example.erp.entity.RespPageBean;
import com.example.erp.mapper.EmployeeMapper;
import com.example.erp.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    public List<Employee> getAllEmp() {
        return employeeMapper.selectAll();
    }

    @Transactional
    public void multiInsert(List<Employee> employees) {
        employeeMapper.multiInsert(employees);
    }

    public RespPageBean getEmpsWithSal(String keyword,Integer page, Integer size) {
        keyword = keyword != null?keyword.trim():null;
        Page<Employee> pages = PageHelper.startPage(page, size);
        List<Employee> list = employeeMapper.getEmpWithSalary(keyword);
        RespPageBean pageBean = new RespPageBean();
        pageBean.setTotal(pages.getTotal());
        pageBean.setData(list);
        return pageBean;
    }

    public RespMes updateEmpSalByEid(Integer eid, Integer sid) {
        int count = employeeMapper.findByEid(eid);
        try {
            if (count == 0){
                employeeMapper.insertToEmpSal(eid,sid);
            }else {
                employeeMapper.updateEmpSal(eid,sid);
            }
        }catch (Exception e){
            e.printStackTrace();
            return RespMes.error("更新失败");
        }
        return RespMes.ok("更新成功");
    }

    public Integer getEmpIdByWorkId(String workId) {
        return employeeMapper.getIdByWorkId(workId);
    }

    public Employee getEmpByWorkId(String workId) {
        return employeeMapper.getEmpByWorkId(workId);
    }

    public Employee getEmployeeByWorkId(String workId) {
        return employeeMapper.getEmployeeByWorkId(workId);
    }

    public List<Employee> getEmpsByDid(Integer departmentId) {
        return employeeMapper.selectByDepartmentId(departmentId);
    }

    public List<DepartmentCountDTO> getDepCount() {
        return employeeMapper.getDepCount();
    }

    public List<EmpAgeDTO> getEmpAgeCount() {
        List<EmpAgeDTO> empAges = new ArrayList<>(); 
        List<EmpAgeTempDTO> unsolvedDates = employeeMapper.getEmpAgeCount();
        try {
            for (EmpAgeTempDTO unsolvedDate : unsolvedDates) {
                EmpAgeDTO dto = new EmpAgeDTO();
                Integer years = Integer.parseInt(unsolvedDate.getYears());
                dto.setAge(DateUtils.getAge(years));
                dto.setCount(unsolvedDate.getCount());
                empAges.add(dto);
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return empAges;
    }
}
