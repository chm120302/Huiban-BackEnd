package com.example.huibanbackend.security.service.impl;


import com.alibaba.fastjson.JSON;
import com.example.huibanbackend.entity.LoginUser;
import com.example.huibanbackend.security.service.SecurityUserService;
import com.example.huibanbackend.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 通过认证器进入登录认证流程，退出认证直接删除redis缓存即可
 */
@Slf4j
@Service
public class SecurityUserServiceImpl implements SecurityUserService {


    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Transactional
    @Override
    public LoginUser login(String username, String password) {

        //使用security认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        log.info("authen token:{}", authenticationToken);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authentication)) {
            throw new RuntimeException("login failed");
        }
        //如果认证通过了，使用userid生成一个jwt jwt存入ajax
        //principal获取通过认证的对象，这个对象通常是 UserDetails 的实例
        LoginUser principal = (LoginUser) authentication.getPrincipal();

        String jwtToken = JwtTokenUtils.getJwtToken(principal.getUsername());
        log.info("jwtToken:{}", jwtToken);
        redisTemplate.opsForValue().set("login_" + principal.getUsername(), JSON.toJSONString(principal), 1, TimeUnit.DAYS);
        log.info("redis:{}",redisTemplate.opsForValue().get("login_" + principal.getUsername()));
        principal.setToken(jwtToken);
        log.info("log principal:{}",principal.getUsername());

        return principal;

    }

    @Override
    public void logout() {
        //获取SecirityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String id = loginUser.getUsername();
        //删除redis中的值
        redisTemplate.delete("login_"+loginUser.getUsername());

    }


}
