package com.example.erp.controller.basic;

import com.example.erp.entity.JobLevel;
import com.example.erp.entity.RespMes;
import com.example.erp.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qzp
 * @date 2020/3/1
 */
@RestController
@RequestMapping("/system/basic/jobLevel")
public class JobLevelController {
    @Autowired
    private JobLevelService jobLevelService;

    @GetMapping("/")
    public List<JobLevel> getAllJobLevels(){
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public RespMes addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespMes.ok("添加成功!");
        }
        return RespMes.error("添加失败!");
    }

    @PutMapping("/")
    public RespMes updateJobLevelById(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateJobLevelById(jobLevel) == 1) {
            return RespMes.ok("更新成功!");
        }
        return RespMes.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespMes deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevelById(id) == 1) {
            return RespMes.ok("删除成功!");
        }
        return RespMes.error("删除失败!");
    }

    @DeleteMapping("/")
    public RespMes deleteJobLevelsByIds(Integer[] ids) {
        if (jobLevelService.deleteJobLevelsByIds(ids) == ids.length) {
            return RespMes.ok("删除成功!");
        }
        return RespMes.error("删除失败!");
    }

}
