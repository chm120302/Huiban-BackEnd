package com.example.huibanbackend.service;

import com.example.huibanbackend.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 业务层接口：用户
 */

public interface UserService {

    //列出所有用户信息
    List<User> getAllInfo();

    // 按照用户email查询信息包括收藏列表
    User getAllInfoByEmail(String email);

    //插入用户
    int insert(User user);

    //删除用户
    int delete(String email);

    //更新用户(不包括密码)
    int update(User user);

    //更新密码
    int updatePassword(@Param("email") String email, @Param("password") String password);


}
