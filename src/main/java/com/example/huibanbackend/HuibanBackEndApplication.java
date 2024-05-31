package com.example.huibanbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

@MapperScan(value = "com.example.huibanbackend.mapper")
public class HuibanBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuibanBackEndApplication.class, args);
    }

}
