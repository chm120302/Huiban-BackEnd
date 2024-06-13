package com.example.huibanbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class Result <T>{
    private Integer code;

    private String msg;

    private T data;

    public Result(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public static <T> Result Success(String msg, T data){
        return new Result<>(HttpStatus.OK.value(), msg,data);
    }

    public static <T> Result Success(T data){
        return new Result<>(HttpStatus.OK.value(),data);
    }

    public static <T> Result fail(String msg){
        return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static <T> Result fail(Integer code, String msg, T data){
        return new Result<>(code,msg,data);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
