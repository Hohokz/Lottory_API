package com.apiwat.LottoryAPI.service;

import com.apiwat.LottoryAPI.entity.RandomNumber;
import com.apiwat.LottoryAPI.repository.LottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LottoService {

    @Autowired
    private LottoRepository lottoRepository;
    public RandomNumber getLotto(){
        return lottoRepository.findByLast();
    }

    public RandomNumber createLotto() {

        RandomNumber randomNumber = new RandomNumber();
        Random rand = new Random();
        int randomFirstPrize = rand.nextInt(1000);
        randomNumber.setRandomFirstPrize( String.format("%03d", randomFirstPrize));

        randomNumber.setNearFirstPrizeLeft( String.format("%03d", randomFirstPrize-1));
        randomNumber.setNearFirstPrizeRight( String.format("%03d", randomFirstPrize+1));

        int randomSecondPrize = rand.nextInt(1000);
        randomNumber.setRandomSecondPrize(String.format("%03d", randomSecondPrize));

        int randomPrize = rand.nextInt(100);
        randomNumber.setTwoNumberPrize(String.format("%02d", randomPrize));
        lottoRepository.save(randomNumber);

        return randomNumber;
    }
}
