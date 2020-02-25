package com.example.erp.service;

import com.example.erp.entity.Hr;
import com.example.erp.entity.Role;
import com.example.erp.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qzp
 * @date 2020/2/15
 */
@Service
public class HrService implements UserDetailsService {
    @Autowired
    private HrMapper hrMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(hrMapper.getRolesById(hr.getId()));
        return hr;
    }
}
