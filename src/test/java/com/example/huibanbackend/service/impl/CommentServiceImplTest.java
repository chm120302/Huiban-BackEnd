package com.example.huibanbackend.service.impl;

import com.example.huibanbackend.entity.Comment;
import com.example.huibanbackend.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CommentServiceImplTest {
    public Comment comment;
    @Autowired
    public CommentServiceImpl commentService;


    public void getData(Comment comment){
        comment.setUserName("chm");
        comment.setImageUrl("https://ts1.cn.mm.bing.net/th/id/R-C.748160bf925a7acb3ba1c9514bbc60db?rik=AYY%2bJ9WcXYIMgw&riu=http%3a%2f%2fseopic.699pic.com%2fphoto%2f50017%2f0822.jpg_wh1200.jpg&ehk=CMVcdZMU6xxsjVjafO70cFcmJvD62suFC1ytk8UuAUk%3d&risl=&pid=ImgRaw&r=0");
//        comment.setCommentTime(new Date());
        comment.setContent("very good!");
        comment.setCategory("Journal");
        comment.setAcademicId("Ad Hoc Network");
        // 由于sql为全部字段插入，无法使用默认值，必须手动赋值
        comment.setParentId(-1);


    }

    @BeforeEach
    public void setUp() throws Exception {
        comment = new Comment();
    }

    @Test
    void listComment() {
        commentService.listComment("Ad Hoc Network");
    }

    @Test
    void saveComment() {
        getData(comment);
        int result = commentService.saveComment(comment);
        System.out.println(result);
    }
}