package com.apiwat.LottoryAPI.controller;

import com.apiwat.LottoryAPI.repository.LottoRepository;
import com.apiwat.LottoryAPI.service.LottoService;
import com.google.gson.Gson;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BaseController {
    private static final Gson gson = new Gson();
    @Autowired
    private LottoService lottoService;
    @GetMapping("/")
    public String test(){
        return "OK!";
    }

    @GetMapping("/lotto")
    public ResponseEntity <String> getLotto(){
        return ResponseEntity.ok(gson.toJson(lottoService.getLotto()));
        

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
