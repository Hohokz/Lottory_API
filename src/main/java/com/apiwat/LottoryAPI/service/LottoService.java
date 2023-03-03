package com.apiwat.LottoryAPI.service;

import com.apiwat.LottoryAPI.entity.RandomNumber;
import com.apiwat.LottoryAPI.repository.LottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LottoService {

    @Autowired
    private LottoRepository lottoRepository;
    public RandomNumber getLotto(){
        return lottoRepository.findByLast();
    }
}
