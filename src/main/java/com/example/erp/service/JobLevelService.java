package com.example.erp.service;

import com.example.erp.entity.JobLevel;
import com.example.erp.mapper.JobLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qzp
 * @date 2020/3/1
 */
@Service
public class JobLevelService {
    @Autowired
    private JobLevelMapper jobLevelMapper;
    public List<JobLevel> getAllJobLevels() {
        return jobLevelMapper.getAll();
    }
}
