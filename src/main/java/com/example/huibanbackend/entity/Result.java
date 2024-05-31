package com.example.huibanbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result <T>{
    public Integer code;

    public String msg;

    public T data;

    public Result(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public static <T> Result Success(String msg, T data){
        return new Result<>(200,msg,data);
    }

    public static <T> Result Success(T data){
        return new Result<>(200,data);
    }

    public static <T> Result fail(String msg){
        return new Result<>(500,msg);
    }

    public static <T> Result fail(Integer code, String msg, T data){
        return new Result<>(code,msg,data);
    }
}
