package com.sopt.mcdonald.burger.api.dto.response;

import com.sopt.mcdonald.burger.domain.*;

import java.util.List;

public record BurgerResponse(
        long id,
        String burger_name,
        String burger_name_eng,
        String description,
        NutritionDto nutritionContent,
        NutritionDto nutritionRef,
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
                buildNutritionRef(burgerEntity),
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

    private static NutritionDto buildNutritionRef(BurgerEntity burgerEntity) {
        return NutritionDto.of(
                burgerEntity.getWeightGRef(),
                burgerEntity.getWeightMlRef(),
                burgerEntity.getCaloriesRef(),
                burgerEntity.getSugarRef(),
                burgerEntity.getProteinRef(),
                burgerEntity.getSaturatedFatRef(),
                burgerEntity.getSodiumRef(),
                burgerEntity.getCaffeineRef()
        );
    }

    private static List<String> buildAllergies(BurgerEntity burgerEntity) {
        return burgerEntity.getAllergies().stream()
                .map(AllergyEntity::getAllergyName)
                .map(Allergy::getKoreanName)
                .toList();
    }
}
