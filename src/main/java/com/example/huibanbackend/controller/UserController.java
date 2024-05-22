package com.example.huibanbackend.controller;

import com.example.huibanbackend.entity.User;
import com.example.huibanbackend.exception.DuplicateUserException;
import com.example.huibanbackend.exception.UserNotFoundException;
import com.example.huibanbackend.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "user controller", description = "测试user相关接口")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/list")
    @Operation(summary = "get all users' information")
    public List<User> getUserList(){
        return userService.getAllInfo();
    }

    @GetMapping("/info/{email}")
    @Operation(summary = "get user information by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public User getUserInfo(@PathVariable String email){
        return userService.getAllInfoByEmail(email);
    }


    @PostMapping
    @Operation(summary = "add user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "201", description = "已创建,成功请求并创建了新的资源"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(responseCode = "409", description = "服务器在完成请求时发生冲突")
    })
    public ResponseEntity<User> addUser(@Parameter @RequestBody User user){
        try{
            userService.insert(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }catch (DuplicateUserException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "delete user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "204", description = "服务器成功处理，但未返回内容"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<Void> deleteUser(@PathVariable String email){
        try {
            userService.delete(email);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    @Operation(summary = "update user information not include password")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<User> updateUser(@RequestBody User user){
        try {
            userService.update(user);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{email}/changePassword")
    @Operation(summary = "update user's password")
    @Parameters(@Parameter(name = "password", description = "password"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "204", description = "服务器成功处理，但未返回内容。"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")

    })
    public ResponseEntity<Void> changePassword(@PathVariable String email, @RequestParam @Parameter String password){
        try {
            userService.updatePassword(email, password);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
