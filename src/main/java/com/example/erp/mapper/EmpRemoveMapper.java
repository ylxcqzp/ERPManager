package com.example.erp.mapper;

import com.example.erp.entity.EmpRemove;

public interface EmpRemoveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmpRemove record);

    int insertSelective(EmpRemove record);

    EmpRemove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmpRemove record);

    int updateByPrimaryKey(EmpRemove record);
}