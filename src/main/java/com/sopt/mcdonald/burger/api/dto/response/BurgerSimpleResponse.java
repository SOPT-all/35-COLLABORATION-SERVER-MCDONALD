package com.sopt.mcdonald.burger.api.dto.response;

import com.sopt.mcdonald.burger.domain.BurgerEntity;

public record BurgerSimpleResponse(long id, String burgerName, String burgerNameEng, boolean isLiked) {

    public BurgerSimpleResponse(BurgerEntity burgerEntity) {
        this(burgerEntity.getBurgerId(), burgerEntity.getBurgerName(), burgerEntity.getBurgerNameEng(), burgerEntity.getIsLiked());
    }
}
