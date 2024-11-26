package com.sopt.mcdonald.burger.api.dto.response;

import com.sopt.mcdonald.burger.domain.BurgerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FavoriteListResponse {
    private List<FavoriteResponse> burgers;

    public static FavoriteListResponse of(List<BurgerEntity> burgerEntities) {
        List<FavoriteResponse> favoriteResponses = burgerEntities.stream()
                .map(FavoriteResponse::of)
                .toList();
        return new FavoriteListResponse(favoriteResponses);
    }
}
