package com.example.erp.service;

import com.example.erp.entity.Hr;
import com.example.erp.entity.RespMes;
import com.example.erp.entity.Role;
import com.example.erp.mapper.HrMapper;
import com.example.erp.mapper.HrRoleMapper;
import com.example.erp.util.QiNiuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author qzp
 * @date 2020/2/15
 */
@Service
public class HrService implements UserDetailsService {
    @Autowired
    private HrMapper hrMapper;
    @Autowired
    private HrRoleMapper hrRoleMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(hrMapper.getRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(String keywords) {
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return hrMapper.getAllHrs(hr.getId(),keywords);
    }

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    @Transactional(rollbackFor = SQLException.class)
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRole(hrid, rids) == rids.length;
    }

    public Integer deleteHrById(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

    public void updateUserFaceUrl(String filepath) throws SQLException{
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String originUrl = hrMapper.getFaceUrl(hr.getId());
        String fileName = originUrl.replace(QiNiuUtils.qiniu_img_url_pre,"");
        QiNiuUtils.deletePic(fileName);
        if (hrMapper.updateFaceUrl(filepath,hr.getId()) == 0){
            throw new SQLException("数据库更新失败");
        }
    }

    public RespMes getFaceUrl() {
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String faceUrl = hrMapper.getFaceUrl(hr.getId());
        return RespMes.ok("",faceUrl);
    }
}
