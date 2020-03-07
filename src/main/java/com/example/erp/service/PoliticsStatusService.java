package com.example.erp.service;

import com.example.erp.entity.PoliticsStatus;
import com.example.erp.mapper.PoliticsStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qzp
 * @date 2020/3/1
 */
@Service
public class PoliticsStatusService {
    @Autowired
    private PoliticsStatusMapper politicsStatusMapper;
    public List<PoliticsStatus> geAllPoliticsStatus() {
        return politicsStatusMapper.getAll();
    }
}
