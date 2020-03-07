package com.example.erp.mapper;

import com.example.erp.entity.Project;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}