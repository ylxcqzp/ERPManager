package com.example.erp.service;

import com.example.erp.entity.EmpRemove;
import com.example.erp.entity.RespMes;
import com.example.erp.mapper.EmpRemoveMapper;
import com.example.erp.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qzp
 * @date 2020/4/3
 */
@Service
public class EmpRemoveService {
    @Autowired
    private EmpRemoveMapper empRemoveMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    public RespMes addEmpRemove(EmpRemove empRemove) {
        try {
            employeeMapper.updateDepAndPos(empRemove.getEmployee());
            empRemoveMapper.insertSelective(empRemove);
        }catch (Exception e){
            e.printStackTrace();
            return RespMes.error("调度失败，数据库操作错误");
        }
        return RespMes.ok("修改成功");
    }
}
