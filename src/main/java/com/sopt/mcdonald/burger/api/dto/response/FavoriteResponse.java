package com.sopt.mcdonald.burger.api.dto.response;

import com.sopt.mcdonald.burger.domain.BurgerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FavoriteResponse {
    private Long id;
    private String burgerName;
    private String burgerNameEng;
    private boolean isLiked;

    public static FavoriteResponse of(BurgerEntity burgerEntity) {
        return new FavoriteResponse(
                burgerEntity.getBurgerId(),
                burgerEntity.getBurgerName(),
                burgerEntity.getBurgerNameEng(),
                burgerEntity.getIsLiked()
        );
    }
}
