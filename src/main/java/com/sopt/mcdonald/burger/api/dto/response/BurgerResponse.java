package com.sopt.mcdonald.burger.api.dto.response;

import com.sopt.mcdonald.burger.domain.AllergyEntity;
import com.sopt.mcdonald.burger.domain.BurgerEntity;
import com.sopt.mcdonald.burger.domain.Allergy;
import com.sopt.mcdonald.burger.domain.NutritionDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public record BurgerResponse(
        long id,
        String burger_name,
        String burger_name_eng,
        String description,
        NutritionDto nutrition,
        List<String> allergy,
        String origin
) {
    public static BurgerResponse of(BurgerEntity burgerEntity) {
        return new BurgerResponse(
                burgerEntity.getBurgerId(),
                burgerEntity.getBurgerName(),
                burgerEntity.getBurgerNameEng(),
                burgerEntity.getDescription(),
                buildNutrition(burgerEntity),
                buildAllergies(burgerEntity),
                burgerEntity.getOrigin()
        );
    }

    private static NutritionDto buildNutrition(BurgerEntity burgerEntity) {
        return NutritionDto.of(
                burgerEntity.getWeightG(),
                burgerEntity.getWeightMl(),
                burgerEntity.getCalories(),
                burgerEntity.getSugar(),
                burgerEntity.getProtein(),
                burgerEntity.getSaturatedFat(),
                burgerEntity.getSodium(),
                burgerEntity.getCaffeine()
        );
    }

    private static List<String> buildAllergies(BurgerEntity burgerEntity) {
        return burgerEntity.getAllergies().stream()
                .map(AllergyEntity::getAllergyName)
                .map(Allergy::getKoreanName)
                .collect(toList());
    }
}
