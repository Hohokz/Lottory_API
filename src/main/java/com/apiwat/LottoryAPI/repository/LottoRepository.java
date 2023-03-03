package com.apiwat.LottoryAPI.repository;

import com.apiwat.LottoryAPI.entity.RandomNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LottoRepository extends JpaRepository<RandomNumber, Long> {
    @Query(value = "SELECT * FROM RandomNumber ORDER BY createDate limit 1", nativeQuery = true)
    public RandomNumber findByLast();


}
