package com.example.erp.service;

import com.example.erp.entity.Hr;
import com.example.erp.entity.Menu;
import com.example.erp.mapper.MenuMapper;
import com.example.erp.mapper.MenuRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author qzp
 * @date 2020/2/15
 */
@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuRoleMapper menuRoleMapper;

    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenuWithRole();
    }

    public List<Menu> getMenuByUserId() {
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return menuMapper.getMenusByHrId(hr.getId());
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteByRid(rid);
        if (mids == null || mids.length == 0) {
            return true;
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        return result==mids.length;
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }
}
