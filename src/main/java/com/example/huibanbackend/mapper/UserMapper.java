package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * 数据访问层接口
 */
public interface UserMapper {
    List<User> getAll();

    User getByEmail(String email);

    List<User> getByUserName(String userName);

    int insert(User user);

    int delete(String email);

    int update(User user);

    int updatePassword(@Param("email") String email, @Param("password") String password);

}
