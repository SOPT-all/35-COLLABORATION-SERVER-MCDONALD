package com.sopt.mcdonald.burger.domain;

import lombok.Getter;

@Getter
public enum Allergy {
    EGG("난류"),
    MILK("우유"),
    SOY("대두"),
    WHEAT("밀"),
    TOMATO("토마토"),
    CHICKEN("닭고기"),
    BEEF("쇠고기"),
    PORK("돼지고기"),
    SHRIMP("새우"),
    SHELLFISH("조개"),
    OYSTER("굴");

    private final String koreanName;

    Allergy(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }
}
