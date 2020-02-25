package com.example.erp.mapper;

import com.example.erp.entity.Mission;

public interface MissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mission record);

    int insertSelective(Mission record);

    Mission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mission record);

    int updateByPrimaryKey(Mission record);
}