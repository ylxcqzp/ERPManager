package com.example.erp.service;

import com.example.erp.entity.*;
import com.example.erp.mapper.EmployeeMapper;
import com.example.erp.mapper.EmployeeRpMapper;
import com.example.erp.mapper.OptionLogMapper;
import com.example.erp.util.OptionLogRecord;
import com.example.erp.util.StringUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author qzp
 * @date 2020/3/27
 */
@Service
public class EmployeeRpService {
    @Autowired
    private EmployeeRpMapper employeeRpMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    public RespPageBean getEmployeeRps(String keyword, Integer page, Integer size, String orderName, String orderBy) {
        orderName = StringUtil.humpToLine(orderName);
        orderBy = StringUtil.humpToLine(orderBy);
        Page<Leave> pages = PageHelper.startPage(page, size);
        List<EmployeeRp> list = employeeRpMapper.getEmpRpsByCondition(keyword,orderName,orderBy);
        RespPageBean pageBean = new RespPageBean();
        pageBean.setTotal(pages.getTotal());
        pageBean.setData(list);
        return pageBean;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteEmpRp(Integer id) {
        employeeRpMapper.deleteByPrimaryKey(id);
        OptionLogRecord.recordLog("删除了一条奖罚消息");
    }

    public RespMes addEmpRp(EmployeeRp employeeRp) {
        try {
            Employee employee = employeeMapper.findByNameAndWorkId(employeeRp.getEmployee().getName(),employeeRp.getEmployee().getWorkId());
            if (employee == null) {
                return RespMes.error("该员工不存在，请重新输入");
            }
            employeeRp.setEmployee(employee);
            employeeRpMapper.insertSelective(employeeRp);
        }catch (Exception e){
            e.printStackTrace();
            return RespMes.error("新增失败，数据库操作失败");
        }
        return RespMes.ok("新增成功");
    }
}
