package com.example.erp.controller.empsys;

import com.example.erp.entity.Comment;
import com.example.erp.entity.Mission;
import com.example.erp.entity.Project;
import com.example.erp.entity.RespMes;
import com.example.erp.service.CommentService;
import com.example.erp.service.MissionService;
import com.example.erp.service.ProjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author qzp
 * @date 2020/4/17
 */
@RestController
@RequestMapping("/emp_sys/project/")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @GetMapping("getAll/{eid}")
    public List<Project> getAllProjects(@PathVariable("eid") @NonNull Integer eid){
        return projectService.getProjects(eid);
    }

    @GetMapping("quit")
    public RespMes deleteEmpProRel(@NonNull Integer eid,@NonNull Integer pid){
        return projectService.deleteEmpProRel(eid,pid);
    }
    @PostMapping("/{empId}")
    public RespMes addProject(@RequestBody Project project,@PathVariable("empId") Integer eid) {
        project.setStatus((byte)0);
        project.setCreateDate(new Date());
        return projectService.addProject(project,eid);
    }

    @GetMapping("/add_group")
    public RespMes addGroups(Integer pid,Integer []eids){
        return projectService.addEmpPro(pid,eids);
    }
}
