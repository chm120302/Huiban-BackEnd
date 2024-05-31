package com.example.huibanbackend.security.service.impl;


import com.example.huibanbackend.entity.LoginUser;
import com.example.huibanbackend.entity.SysPerm;
import com.example.huibanbackend.entity.User;
import com.example.huibanbackend.mapper.PermMapper;
import com.example.huibanbackend.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Slf4j
@Service
@Configuration
public class SecurityUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermMapper permMapper;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername username:{}", username);

        User user = userMapper.getByEmail(username);

        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或密码错误");
        }

        LoginUser loginUser = new LoginUser();

        loginUser.setUsername(user.getEmail());
        loginUser.setPassword(passwordEncoder().encode(user.getPassword()));
        //根据用户查询权限信息 添加到LoginUser中
        List<SysPerm> perms= permMapper.getPermByEmail(user.getEmail());
        List<String> permsList = perms.stream().map(s -> s.getPerms()).collect(Collectors.toList());
        loginUser.setPermissions(permsList);
        return loginUser;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}