package com.example.huibanbackend.controller;


import com.example.huibanbackend.entity.Comment;
import com.example.huibanbackend.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "comment controller", description = "测试comment相关接口")
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping("/{academicId}/comments")
    @Operation(summary = "list the comments about conference/ journal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public List<Comment> listComments(Model model, @PathVariable String academicId) {
        List<Comment> comments = commentService.listComment(academicId);
//        model.addAttribute("comments", comments);
//        return "comment :: commentList";
        return comments;
    }

    @PostMapping("/comment")
    @Operation(summary = "add comment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "201", description = "已创建,成功请求并创建了新的资源"),
            @ApiResponse(responseCode = "400", description = "语法格式错误，服务器无法理解"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<Comment> addComment(@Parameter @RequestBody Comment comment) {
        if(comment.getParentComment() == null){
            comment.setParentComment(null);
            comment.setParentId(-1);
            comment.setParentUsername(null);
            comment.setParentImageurl(null);
        }
        else if(comment.getParentComment().getId() != null){
            comment.setParentId(comment.getParentComment().getId());
        }
        int flag = commentService.saveComment(comment);
        if(flag == 1){
            return ResponseEntity.status(HttpStatus.CREATED).body(comment);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
//        return "redirect:/comment";
    }

    @DeleteMapping("/comment/{id}")
    @Operation(summary = "delete comment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<Integer> deleteComment(@PathVariable Integer id) {
        int isDeleted = commentService.deleteComment(id);
        if(isDeleted != 1){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }





}
