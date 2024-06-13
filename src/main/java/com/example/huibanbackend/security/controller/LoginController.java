package com.example.huibanbackend.security.controller;


import com.example.huibanbackend.entity.LoginUser;
import com.example.huibanbackend.entity.Result;
import com.example.huibanbackend.entity.User;
import com.example.huibanbackend.mapper.UserMapper;
import com.example.huibanbackend.mapper.UserRoleMapper;
import com.example.huibanbackend.security.service.impl.SecurityUserServiceImpl;
import com.example.huibanbackend.utils.AvatarHelper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@Tag(name = "login controller", description = "测试认证和授权接口")
@RestController
@RequestMapping(value = "/auth")
public class LoginController {

    @Autowired
    private SecurityUserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Operation(summary = "login")
    public Result<LoginUser> login(@RequestBody LoginUser loginUser){
        LoginUser login = userService.login(loginUser.getUsername(), loginUser.getPassword());
        return Result.Success(login);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Operation(summary = "register")
    public Result<User> register(@RequestBody @Valid User user) {
        String email = user.getEmail();
        User _user = userMapper.getAllInfoByEmail(email);
        if(Objects.nonNull(_user)){
            return Result.fail(HttpStatus.METHOD_NOT_ALLOWED.value(),"用户id已存在", email);
        }
        try { //自动生成base64编码的头像
             if(user.getImageUrl() == null || user.getImageUrl().isEmpty()){
                 user.setImageUrl(AvatarHelper.createBase64Avatar());
             }
            userMapper.insert(user);
            userRoleMapper.insertUserRole(email, "ROLE_USER");
            return Result.Success("用户注册成功");
        }catch (Exception e){
            return Result.fail("用户注册过程中遇到异常：" + e);
        }
    }

    @GetMapping("/logout")
    @Operation(summary = "logout")
    public Result<Void> logout() {
        userService.logout();
        return Result.Success("用户成功登出", null);
    }


    /**
     * 登录失败异常的处理
     */
    @GetMapping("/toError")
    @Operation(summary = "login error")
    public void loginError(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");

        AuthenticationException exception =
                (AuthenticationException) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            response.getWriter().write(exception.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/index")
    @Operation(summary = "test if the login function is available")
    public String index() {
        return "index,security";
    }



}
