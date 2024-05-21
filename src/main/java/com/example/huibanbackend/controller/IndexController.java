package com.example.huibanbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/indexPage")
    public String index(){
        return "/index";
    }

}
