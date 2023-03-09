package com.apiwat.LottoryAPI.service;

import com.apiwat.LottoryAPI.entity.CheckResponseModel;
import com.apiwat.LottoryAPI.entity.ObjectResponseModel;
import com.apiwat.LottoryAPI.entity.RandomNumber;
import com.apiwat.LottoryAPI.entity.ResponseModel;
import com.apiwat.LottoryAPI.repository.LottoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class LottoService {

    @Autowired
    private LottoRepository lottoRepository;
    public RandomNumber getLotto(){
        return lottoRepository.findByLast();
    }

    public ResponseModel createLotto() {

        RandomNumber randomNumber = new RandomNumber();
        Random rand = new Random();
        int randomFirstPrize = rand.nextInt(1000);
        randomNumber.setRandomFirstPrize(String.format("%03d", randomFirstPrize));

        randomNumber.setNearFirstPrizeLeft(String.format("%03d", randomFirstPrize - 1));
        randomNumber.setNearFirstPrizeRight(String.format("%03d", randomFirstPrize + 1));

        int randomSecondPrize = rand.nextInt(1000);
        randomNumber.setRandomSecondPrize(String.format("%03d", randomSecondPrize));

        int randomPrize = rand.nextInt(100);
        randomNumber.setTwoNumberPrize(String.format("%02d", randomPrize));
        lottoRepository.save(randomNumber);

        return new ObjectResponseModel("success", "", randomNumber);

    }
    public ResponseModel checkLotto (String keyword) {

        if(keyword.length() != 3){
            return new ResponseModel("fail","คุณใส่เลขไม่ครบนะ");
        }

        RandomNumber randomNumber = lottoRepository.findByLast();
        ArrayList <String> hitPrize = new ArrayList<>();


        if (StringUtils.equals(keyword, randomNumber.getRandomFirstPrize())) {
            hitPrize.add("ยินดีด้วยคุณถูกรางวัลที่ 1");
        }
        if (StringUtils.equals(keyword, randomNumber.getNearFirstPrizeLeft())) {
            hitPrize.add("ยินดีด้วยคุณถูกใกล้เคียงรางวัลที่รางวัลที่ 1");
        }
        if (StringUtils.equals(keyword, randomNumber.getNearFirstPrizeRight())) {
            hitPrize.add("ยินดีด้วยคุณถูกใกล้เคียงรางวัลที่รางวัลที่ 1");
        }
        if (StringUtils.equals(keyword, randomNumber.getRandomSecondPrize())) {
            hitPrize.add("ยินดีด้วยคุณถูกรางวัลที่ 2");
        }
        if (StringUtils.equals(keyword.substring(1), randomNumber.getTwoNumberPrize())) {
            hitPrize.add("ยินดีด้วยคุณถูกรางวัลเลขท้ายสองตัว");
        }
        if (hitPrize.toArray().length == 0) {
            hitPrize.add("เสียใจจริงๆ คุณไม่ถูกรางวัล");
        }

        return  new CheckResponseModel("success", "",hitPrize);
    }
}
