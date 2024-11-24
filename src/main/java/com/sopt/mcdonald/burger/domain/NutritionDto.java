package com.sopt.mcdonald.burger.domain;

public record NutritionDto(Integer weightG, Integer weightML, Integer calories, Integer sugar, Integer protein, Integer saturatedFat, Integer sodium, Integer caffeine) {
    public static NutritionDto of(Integer weightG, Integer weightML, Integer calories, Integer sugar, Integer protein, Integer saturatedFat, Integer sodium, Integer caffeine) {
        return new NutritionDto(weightG, weightML, calories, sugar, protein, saturatedFat, sodium, caffeine);
    }
}
