package com.example.huibanbackend.service.impl;

import com.example.huibanbackend.entity.Comment;
import com.example.huibanbackend.mapper.CommentMapper;
import com.example.huibanbackend.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    //存放迭代找出的所有子代集合
    private List<Comment> tempReplys= new ArrayList<>();


    /**
     * 查询所有评论
     * @return 评论列表
     */
    @Transactional
    @Override
    public List<Comment> listComment(String academicId) {
        //查询所有父节点评论
        List<Comment> comments = commentMapper.findByParentId(academicId, Integer.parseInt("-1"));
        for(Comment comment : comments) {
            Integer id = comment.getId();
            String parentName = comment.getUserName();
            String parentImage = comment.getParentImageurl();
            List<Comment> chilldComments = commentMapper.findByCommentId(academicId, id);
            // 查询子评论
            combineChildren(academicId,chilldComments, parentName, parentImage);
            comment.setReplys(tempReplys);
            tempReplys.clear();

        }
        return comments;
    }

    /**
     * 查询出父评论下的所有子评论
     * @param childComments 一级评论列表
     * @param parentUsername 父评论用户名
     * @param parentImageurl 父评论头像
     */
    private void combineChildren(String academicId, List<Comment> childComments, String parentUsername, String parentImageurl){
        //判断是否有子一级评论
        if(!childComments.isEmpty()){
            for(Comment childComment : childComments){
                String parentName = childComment.getUserName();;
                String parentImage = childComment.getImageUrl();
                childComment.setParentUsername(parentUsername);
                childComment.setParentImageurl(parentImageurl);
                tempReplys.add(childComment);
                Integer childId = childComment.getId();
                recursively(academicId, childId, parentName, parentImage);
            }
        }
    }

    /**
     * 递归找出子评论的二级评论
     * @param childId 子评论id
     * @param parentUsername  子评论用户名
     * @param parentImageurl  子评论头像
     */
    private void recursively(String academicId, Integer childId, String parentUsername, String parentImageurl){
        List<Comment> replyComments = commentMapper.findByReplyId(academicId, childId);
        if(!replyComments.isEmpty()){
            for(Comment replyComment : replyComments){
                String parentName = replyComment.getUserName();
                String parentImage = replyComment.getImageUrl();
                replyComment.setParentUsername(parentUsername);
                replyComment.setParentImageurl(parentImageurl);
                Integer replyId = replyComment.getId();
                tempReplys.add(replyComment);

                recursively(academicId, replyId, parentName, parentImage);
            }
        }

    }

    /**
     * 保存评论
     */
    @Override
    public int saveComment(Comment comment) {
        comment.setCommentTime(new Date());
        return commentMapper.saveComment(comment);
    }

    @Override
    public int deleteComment(Integer id) {
        return commentMapper.deleteComment(id);
    }
}
