package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * 数据访问层接口
 */
public interface UserMapper {
    //查询所有用户的信息包括收藏列表
    List<User> getAllInfo();

    // 按照用户email查询信息包括收藏列表
    User getAllInfoByEmail(String email);

    List<User> getAll();

    User getByEmail(String email);

    List<User> getByUserName(String userName);

    int insert(User user);

    int delete(Integer id);

    int update(User user);

    int updatePassword(@Param("email") String email, @Param("password") String password);

}
