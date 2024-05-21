package com.example.huibanbackend.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService() {
//        //创建基于内存的用户信息管理器
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        //创建UserDetail对象，用户管理用户名、用户密码、用户角色、权限等
//        manager.createUser(
//                User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
//        return manager;
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        //创建基于数据库的用户信息管理器
        DBUserDetailsManager manager = new DBUserDetailsManager();
        return manager;
    }


}