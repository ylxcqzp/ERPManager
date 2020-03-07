package com.example.erp.mapper;

import com.example.erp.entity.JobLevel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobLevel record);

    int insertSelective(JobLevel record);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);

    List<JobLevel> getAll();
}