package com.example.erp.controller.empsys;

import com.example.erp.entity.Comment;
import com.example.erp.entity.DTO.MissionAttention;
import com.example.erp.entity.Employee;
import com.example.erp.entity.Mission;
import com.example.erp.entity.RespMes;
import com.example.erp.service.CommentService;
import com.example.erp.service.EmployeeService;
import com.example.erp.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author qzp
 * @date 2020/4/18
 */
@RestController
@RequestMapping("/emp_sys/missions")
public class MissionController {
    @Autowired
    private MissionService missionService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{pid}")
    public List<Mission> getMissionsByPid(@PathVariable("pid") Integer pid){
        return missionService.getMissionsByPid(pid);
    }

    @GetMapping("/comments/{missionId}")
    public List<Comment> getComments(@PathVariable("missionId") @NonNull Integer missionId){
        return commentService.getComments(missionId);
    }

    @PostMapping({"/status/","/mission_detail","/managerId"})
    public RespMes updateMission(@RequestBody Mission mission){
        return missionService.update(mission);
    }

    @GetMapping("/delete_manager/{missionId}")
    public RespMes deleteMissionManager(@PathVariable("missionId") @NonNull Integer missionId){
        return missionService.deleteMissionManager(missionId);
    }

    @PostMapping("/comment/add")
    public RespMes addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @PostMapping("/attention/")
    public RespMes attentionChange(@RequestBody MissionAttention attention){
        System.out.println(attention);
        return missionService.changeAttention(attention);
    }

    @GetMapping("/attentions/{eid}")
    public Set<Object> getAttentions(@PathVariable("eid") Integer eid){
        return missionService.getAttentionsByEid(eid);
    }

    @GetMapping("/develops/{departmentId}")
    public List<Employee> getEmployees(@PathVariable("departmentId") Integer departmentId){
        return employeeService.getEmpsByDid(departmentId);
    }

}
