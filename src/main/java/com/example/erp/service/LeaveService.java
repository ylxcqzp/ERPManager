package com.example.erp.service;

import com.example.erp.entity.Hr;
import com.example.erp.entity.Leave;
import com.example.erp.entity.RespPageBean;
import com.example.erp.mapper.LeaveMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author qzp
 * @date 2020/3/26
 */
@Service
public class LeaveService {

    @Autowired
    private LeaveMapper leaveMapper;

    public RespPageBean getAllLeave(String keyword, Integer page, Integer size) {
        keyword = keyword != null?keyword.trim():null;
        Page<Leave> pages = PageHelper.startPage(page, size);
        List<Leave> list = leaveMapper.getLeavesWithCondition(keyword);
        RespPageBean pageBean = new RespPageBean();
        pageBean.setTotal(pages.getTotal());
        pageBean.setData(list);
        return pageBean;
    }

    public void updateStatus(Integer id, Integer status) {
        Hr hr = (Hr)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Date date = new Date();
        leaveMapper.updateStatus(id,status,hr.getId(),date);
    }

    public RespPageBean getLeaveWithMonth(Date begin, Date end) {
        Page<Leave> pages = PageHelper.startPage(1, 100);
        List<Leave> list = leaveMapper.getLeavesByDate(begin,end);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(list);
        respPageBean.setTotal(pages.getTotal());
        return respPageBean;
    }
}
