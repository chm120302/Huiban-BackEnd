package com.example.huibanbackend.controller;

import com.example.huibanbackend.entity.Result;
import com.example.huibanbackend.entity.User;
import com.example.huibanbackend.exception.DuplicateException;
import com.example.huibanbackend.exception.NotFoundException;
import com.example.huibanbackend.mapper.UserRoleMapper;
import com.example.huibanbackend.service.UserService;

import com.example.huibanbackend.utils.AvatarHelper;
import com.example.huibanbackend.utils.WebUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Tag(name = "user controller", description = "测试user相关接口")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @GetMapping("/list")
    @PreAuthorize("@myAccess.hasAuthority('4')")
    @Operation(summary = "get all users' information")
    public Result<List<User>> getUserList(){
        List<User> users = userService.getAllInfo();
        return Result.Success("get all", users);
    }

    @GetMapping("/info")
    @Operation(summary = "get user information by email")
    @PreAuthorize("@myAccess.hasAuthority('5')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<User> getUserInfo(){
        String email = WebUtils.getEmailFromHeader(request);
        try{
            User user = userService.getAllInfoByEmail(email);
            return Result.Success(user);

        } catch (NotFoundException e){
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);

        }

    }


    @PostMapping
    @Operation(summary = "add user")
    @PreAuthorize("@myAccess.hasAuthority('3')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "201", description = "已创建,成功请求并创建了新的资源"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(responseCode = "409", description = "服务器在完成请求时发生冲突")
    })
    public Result<User> addUser(@RequestBody User user, @RequestParam String role){
        try{
            if(user.getImageUrl() == null || user.getImageUrl().isEmpty()){
                user.setImageUrl(AvatarHelper.createBase64Avatar());
            }
            userService.insert(user);
            if(role.equals("ROLE_ADMIN") || role.equals("ROLE_USER")){
                userRoleMapper.insertUserRole(user.getEmail(), role);
            } else {
                return Result.fail(HttpStatus.BAD_REQUEST.value(), "incorrect role, please input ROLE_ADMIN or ROLE_USER", role);
            }


            return Result.Success("create", user);

        }catch (DuplicateException e){
            return Result.fail(HttpStatus.CONFLICT.value(), "conflict", null);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "delete user")
    @PreAuthorize("@myAccess.hasAuthority('6')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "204", description = "服务器成功处理，但未返回内容"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<Void> deleteUser(@PathVariable String email){
        try {
            userService.delete(email);
            return Result.Success("delete", null);

        } catch (NotFoundException e) {
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }

    @PutMapping("/update")
    @Operation(summary = "update user information not include password")
    @PreAuthorize("@myAccess.hasAuthority('2')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<User> updateUser(@RequestBody User user){
        String email = WebUtils.getEmailFromHeader(request);
        user.setEmail(email);
        try {
            userService.update(user);
            return Result.Success("update", user);

        } catch (NotFoundException e) {
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }

    }

    @PutMapping("/changePassword")
    @Operation(summary = "update user's password")
    @PreAuthorize("@myAccess.hasAuthority('1')")
    @Parameters(@Parameter(name = "password", description = "password"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "204", description = "服务器成功处理，但未返回内容。"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")

    })
    public Result<Void> changePassword(@RequestBody User user){
        try {
            String email = WebUtils.getEmailFromHeader(request);
            String password = user.getPassword();
            userService.updatePassword(email, password);
            return Result.Success("change password", null);
        } catch (NotFoundException e) {
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }


}
