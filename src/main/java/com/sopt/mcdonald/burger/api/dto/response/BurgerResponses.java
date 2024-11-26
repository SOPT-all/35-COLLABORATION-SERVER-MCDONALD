package com.sopt.mcdonald.burger.api.dto.response;

import java.util.List;
import com.sopt.mcdonald.burger.domain.BurgerEntity;

public record BurgerResponses(List<BurgerSimpleResponse> burgers) {

    public static BurgerResponses from(List<BurgerEntity> burgers) {
        List<BurgerSimpleResponse> responses = burgers.stream()
                .map(BurgerSimpleResponse::new)
                .toList();
        return new BurgerResponses(responses);
    }
}
