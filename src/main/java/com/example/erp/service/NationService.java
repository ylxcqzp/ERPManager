package com.example.erp.service;

import com.example.erp.entity.Nation;
import com.example.erp.mapper.NationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qzp
 * @date 2020/3/1
 */
@Service
public class NationService {
    @Autowired
    private NationMapper nationMapper;
    public List<Nation> getAllNations() {
        return nationMapper.getAll();
    }
}
