package com.example.erp.mapper;

import com.example.erp.entity.Hr;
import com.example.erp.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getRolesById(Integer id);

    List<Hr> getAllHrs(@Param("hrid") Integer id, @Param("keywords") String keywords);

    int updateFaceUrl(@Param("filepath") String filepath,@Param("id")Integer id);

    String getFaceUrl(Integer id);
}