package com.example.huibanbackend.config;

import com.alibaba.fastjson.JSON;
import com.example.huibanbackend.entity.LoginUser;
import com.example.huibanbackend.utils.JwtTokenUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        //jwt token 例子：
        //Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTcxMjY4MTksImVtYWlsIjoiYWRtaW4ifQ.n4_0gTpVnqrGY1E6bCH9p-Q_3bFoDB_cH_LG1Cn2Xb4'
        String token = request.getHeader("Authorization");

        log.info("request:{}", request.getHeaderNames());
        log.info("token:{}", token);
        String loginUserString = null;
        try {

        if (!StringUtils.hasText(token)) {
            //放行
            filterChain.doFilter(request, response);
            return;
        }

        token = token.substring(7);
        String userId = JwtTokenUtils.getEmailFromToken(token);
        loginUserString= redisTemplate.opsForValue().get("login_" + userId);
        }catch (Exception e) {
//            e.printStackTrace();
            throw new RuntimeException("用户未登录");
        }
        
        LoginUser loginUser = JSON.parseObject(loginUserString, LoginUser.class);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}