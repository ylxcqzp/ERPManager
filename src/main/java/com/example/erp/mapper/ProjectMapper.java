package com.example.erp.mapper;

import com.example.erp.entity.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    List<Project> getProjectsByEid(@Param("eid") Integer eid);

    int deleteFromEmpPro(@Param("eid") Integer eid,@Param("pid") Integer pid);
}