package com.example.erp.service;

import com.example.erp.entity.DTO.MissionAttention;
import com.example.erp.entity.Mission;
import com.example.erp.entity.RespMes;
import com.example.erp.mapper.MissionMapper;
import com.example.erp.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author qzp
 * @date 2020/4/18
 */
@Service
public class MissionService {
    @Autowired
    private MissionMapper missionMapper;
    @Autowired
    private RedisUtil redisUtil;

    public List<Mission> getMissionsByPid(Integer pid) {
        return missionMapper.selectByPid(pid);
    }

    public RespMes update(Mission mission) {
        if (missionMapper.updateByPrimaryKeySelective(mission) == 1){
            return RespMes.ok("更新成功");
        }
        return RespMes.error("更新失败");
    }

    public RespMes changeAttention(MissionAttention attention) {
        String userKey = "user_" + attention.getUserId();
        String missionKey = "mission_" + attention.getMissionId();
        /*如果是关注，向redis添加数据*/
        try {
            if (attention.getAttention()){
                redisUtil.sSet(userKey,attention.getMissionId());
                redisUtil.sSet(missionKey,attention.getUserId());
            }else {
                redisUtil.setRemove(userKey,attention.getMissionId());
                redisUtil.setRemove(missionKey,attention.getUserId());
            }
        }catch (Exception e){
            e.printStackTrace();
            return RespMes.error("操作失败！");
        }
        return RespMes.ok(attention.getAttention()? "已关注":"已取消关注");

    }

    public Set<Object> getAttentionsByEid(Integer eid) {
        return redisUtil.sGet("user_" + eid);
    }

    public RespMes deleteMissionManager(Integer missionId) {
        try {
            missionMapper.deleteManager(missionId);
        }catch (Exception e){
            e.printStackTrace();
            return RespMes.error("未知错误，请重试");
        }
        return RespMes.ok("已清除负责人");

    }

    public RespMes addMission(Mission mission) {
        if (missionMapper.insertSelective(mission) == 1){
            return RespMes.ok("添加成功");
        }
        return RespMes.error("添加失败");
    }
}
