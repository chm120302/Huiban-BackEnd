package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    //添加一个评论
    int saveComment(Comment comment);

    //查询父级评论
    List<Comment> findByParentId(@Param("academicId") String academicId, @Param("parentId") Integer parentId);

    //查询一级回复
    List<Comment> findByCommentId(@Param("academicId") String academicId, @Param("id") Integer id);

    // 查询二级以及所有子集回复
    List<Comment> findByReplyId(@Param("academicId") String academicId, @Param("childId") Integer childId);

    //删除评论
    int deleteComment(@Param("id") Integer id);
}
