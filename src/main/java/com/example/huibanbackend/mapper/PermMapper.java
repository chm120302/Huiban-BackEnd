package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.SysPerm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PermMapper {

    //根据email获得用户的权限
    List<SysPerm> getPermByEmail(String email);
}
