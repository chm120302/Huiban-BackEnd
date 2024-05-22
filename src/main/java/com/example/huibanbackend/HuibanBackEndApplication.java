package com.example.huibanbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication

@MapperScan(value = "com.example.huibanbackend.mapper")
//@SpringBootApplication
public class HuibanBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuibanBackEndApplication.class, args);
    }

}
