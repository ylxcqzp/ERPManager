package com.example.erp.service;

import com.example.erp.entity.AdjustSalary;
import com.example.erp.entity.RespMes;
import com.example.erp.entity.RespPageBean;
import com.example.erp.mapper.AdjustSalaryMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qzp
 * @date 2020/4/1
 */
@Service
public class AdjustSalaryService {
    @Autowired
    private AdjustSalaryMapper adjustSalaryMapper;


    public RespPageBean getAdjustSalaries(String keyword, Integer page, Integer size, String orderBy, String orderName) {
        Page<AdjustSalary> pages = PageHelper.startPage(page, size);
        List<AdjustSalary> list = adjustSalaryMapper.getAdjustSalaryByCondition(keyword,orderName,orderBy);
        RespPageBean pageBean = new RespPageBean();
        pageBean.setTotal(pages.getTotal());
        pageBean.setData(list);
        return pageBean;
    }

    public RespMes getByEid(Integer eid) {
        AdjustSalary adjustSalary = adjustSalaryMapper.getByEid(eid);
        adjustSalary.setAfterSalary(0);
        return RespMes.ok("",adjustSalary);
    }

    public RespMes addSalAdjust(AdjustSalary adjustSalary) {
        try {
            adjustSalaryMapper.insertSelective(adjustSalary);
        }catch (Exception e){
            e.printStackTrace();
            return RespMes.error("新增失败");
        }
        return RespMes.ok("新增成功，记录已更新");
    }
}
