package com.example.erp.mapper;

import com.example.erp.entity.Leave;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leave record);

    int insertSelective(Leave record);

    Leave selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Leave record);

    int updateByPrimaryKey(Leave record);
}