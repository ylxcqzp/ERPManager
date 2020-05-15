package com.example.erp.mapper;

import com.example.erp.entity.Leave;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LeaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leave record);

    int insertSelective(Leave record);

    Leave selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Leave record);

    int updateByPrimaryKey(Leave record);

    List<Leave> getLeavesWithCondition(@Param("keyword") String keyword);

    int updateStatus(@Param("id") Integer id, @Param("status") Integer status,@Param("hrid")Integer hrid,@Param("handleDate")Date handleDate);

    List<Leave> getLeavesByDate(@Param("begin") Date begin, @Param("end") Date end);

    List<Leave> getLeaveByDateScope(@Param("beginDate") Date beginDate,@Param("endDate") Date endDate);

    int insertLeave(Leave leave);

    List<Leave> findByEid(Integer eid);
}