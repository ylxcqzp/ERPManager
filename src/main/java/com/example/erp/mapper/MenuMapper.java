package com.example.erp.mapper;

import com.example.erp.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getAllMenuWithRole();

    List<Menu> getAllMenus();

    List<Menu> getMenusByHrId(Integer hrid);

    List<Integer> getMidsByRid(Integer rid);
}