package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * 数据访问层接口
 */
@Repository
@Mapper
public interface UserMapper {
    //查询所有用户的信息包括收藏列表
    List<User> getAllInfo();

    // 按照用户email查询信息包括收藏列表
    User getAllInfoByEmail(String email);

    // 查询所有用户信息不包括收藏列表
    List<User> getAll();

    //通过email查询用户
    User getByEmail(String email);

    //通过用户名查询用户
    List<User> getByUserName(String userName);

    //插入用户
    int insert(User user);

    //删除用户
    int delete(Integer id);

    //更新用户(不包括密码)
    int update(User user);

    //更新密码
    int updatePassword(@Param("email") String email, @Param("password") String password);

}
