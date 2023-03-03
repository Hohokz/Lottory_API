package com.apiwat.LottoryAPI.entity;

import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RandomNumber")
public class RandomNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "randomFirstPrize")
    private String randomFirstPrize;

    @Column(name = "randomSecondPrize")
    private String randomSecondPrize;

    @Column(name = "nearFirstPrizeLeft")
    private String nearFirstPrizeLeft;

    @Column(name = "nearFirstPrizeRight")
    private String nearFirstPrizeRight;

    @Column(name = "twoNumberPrize")
    private String twoNumberPrize;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @PrePersist
    public void prePersist(){
        createDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRandomFirstPrize() {
        return randomFirstPrize;
    }

    public void setRandomFirstPrize(String randomFirstPrize) {
        this.randomFirstPrize = randomFirstPrize;
    }

    public String getRandomSecondPrize() {
        return randomSecondPrize;
    }

    public void setRandomSecondPrize(String randomSecondPrize) {
        this.randomSecondPrize = randomSecondPrize;
    }

    public String getNearFirstPrizeLeft() {
        return nearFirstPrizeLeft;
    }

    public void setNearFirstPrizeLeft(String nearFirstPrizeLeft) {
        this.nearFirstPrizeLeft = nearFirstPrizeLeft;
    }

    public String getNearFirstPrizeRight() {
        return nearFirstPrizeRight;
    }

    public void setNearFirstPrizeRight(String nearFirstPrizeRight) {
        this.nearFirstPrizeRight = nearFirstPrizeRight;
    }

    public String getTwoNumberPrize() {
        return twoNumberPrize;
    }

    public void setTwoNumberPrize(String twoNumberPrize) {
        this.twoNumberPrize = twoNumberPrize;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
