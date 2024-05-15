package com.example.huibanbackend.controller;


import com.example.huibanbackend.entity.Comment;
import com.example.huibanbackend.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/cc")
    public String cc(){
        return "comment";
    }

    @GetMapping("/comment")
    public String listComments(Model model) {
        List<Comment> comments = commentService.listComment();
        model.addAttribute("comments", comments);
        return "comment :: commentList";
    }

    @PostMapping("/comment")
    public String addComment(Comment comment) {
        if(comment.getParentComment().getId() != null){
            comment.setParentId(comment.getParentComment().getId());
        }
        commentService.saveComment(comment);
        return "redirect:/comment";
    }





}
