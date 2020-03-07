package com.example.erp.service;

import com.example.erp.entity.Department;
import com.example.erp.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qzp
 * @date 2020/3/1
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    public List<Department> getAllDeps() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }
}
