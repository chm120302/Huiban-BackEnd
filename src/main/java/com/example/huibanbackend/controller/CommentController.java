package com.example.huibanbackend.controller;


import com.example.huibanbackend.entity.Comment;
import com.example.huibanbackend.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/cc")
    public String cc(){
        return "comment";
    }

    @GetMapping("/{academicId}/comments")
    public String listComments(Model model, @PathVariable String academicId) {
        List<Comment> comments = commentService.listComment(academicId);
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

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<Integer> deleteComment(@PathVariable int id) {
        int isDeleted = commentService.deleteComment(id);
        if(isDeleted != 1){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }





}
