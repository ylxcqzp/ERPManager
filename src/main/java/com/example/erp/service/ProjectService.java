package com.example.erp.service;

import com.example.erp.entity.Project;
import com.example.erp.entity.RespMes;
import com.example.erp.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qzp
 * @date 2020/4/17
 */
@Service
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    public List<Project> getProjects(Integer eid) {
        return projectMapper.getProjectsByEid(eid);
    }

    public RespMes deleteEmpProRel(Integer eid, Integer pid) {
        if (projectMapper.deleteFromEmpPro(eid,pid) == 1){
            return RespMes.ok("已退出该项目");
        }
        return RespMes.error("退出失败，未知错误");
    }
}
