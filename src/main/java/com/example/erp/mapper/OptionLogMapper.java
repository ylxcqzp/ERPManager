package com.example.erp.mapper;

import com.example.erp.entity.OptionLog;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OptionLog record);

    int insertSelective(OptionLog record);

    OptionLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OptionLog record);

    int updateByPrimaryKey(OptionLog record);
}