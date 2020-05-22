package com.example.erp.service;

import com.example.erp.entity.Project;
import com.example.erp.entity.RespMes;
import com.example.erp.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
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

    @Transactional(rollbackFor = SQLException.class)
    public RespMes addProject(Project project,Integer eid) {
        try {
            projectMapper.insertSelective(project);
            projectMapper.insertEmpPro(eid, project.getId());
        } catch (Exception e) {
            return RespMes.error("操作失败，数据库执行错误");
        }
        return RespMes.ok("新项目已创建");
    }

    public RespMes addEmpPro(Integer pid, Integer[] eids) {
        if (projectMapper.addEmpPro(pid,eids) != 0){
            return RespMes.ok("添加成功");
        }
        return RespMes.error("添加失败");
    }
}
