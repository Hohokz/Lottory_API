package com.apiwat.LottoryAPI.controller;


import com.apiwat.LottoryAPI.service.LottoService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BaseController {
    private static final Gson gson = new Gson();
    @Autowired
    private LottoService lottoService;

    @GetMapping("/")
    public String test() {
        return "OK!";
    }

    @GetMapping("/lotto")
    public ResponseEntity<String> getLotto() {
        return ResponseEntity.ok(gson.toJson(lottoService.getLotto()));
    }

    @PostMapping("/lotto")
    public ResponseEntity<String> createLotto() {
        return ResponseEntity.ok(gson.toJson(lottoService.createLotto()));
    }

    @GetMapping("/lotto/check")
    public ResponseEntity<String> handleRequest(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(gson.toJson(lottoService.checkLotto(keyword)));
    }
}