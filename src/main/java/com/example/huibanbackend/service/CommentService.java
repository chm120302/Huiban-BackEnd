package com.example.huibanbackend.service;

import com.example.huibanbackend.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层接口：评论
 */

public interface CommentService {

    //查询评论列表
    List<Comment> listComment(String academicId);

    //保存评论
    int saveComment(Comment comment);

    //删除评论
    int deleteComment(Integer id);

}
