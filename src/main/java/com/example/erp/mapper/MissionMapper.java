package com.example.erp.mapper;

import com.example.erp.entity.Mission;
import com.example.erp.entity.RespMes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mission record);

    int insertSelective(Mission record);

    Mission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mission record);

    int updateByPrimaryKey(Mission record);

    List<Mission> selectByPid(@Param("pid") Integer pid);

    int deleteManager(Integer missionId);
}