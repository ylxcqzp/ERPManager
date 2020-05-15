package com.example.erp.service;

import com.example.erp.entity.Comment;
import com.example.erp.entity.RespMes;
import com.example.erp.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author qzp
 * @date 2020/4/21
 */
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> getComments(Integer missionId) {
        return commentMapper.selectByMissionId(missionId);
    }

    public RespMes addComment(Comment comment) {
        comment.setCreateDate(new Date());
        if (commentMapper.insertSelective(comment) == 1){
            return RespMes.ok("");
        }
        return RespMes.error("提交错误，请重试");
    }
}
