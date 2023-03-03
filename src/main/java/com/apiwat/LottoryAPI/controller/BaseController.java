package com.apiwat.LottoryAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BaseController {
    @GetMapping("/")
    public String test(){
        return "OK!";
    }

    @GetMapping("/lotto")
    public String getLotto(){
        return "OK!";
    }

    @PostMapping("/lotto")
    public String createLotto(){
        return "OK!";
    }

    @GetMapping("/lotto/check")
    public String checkLotto(){
        return "OK!";
    }
}
