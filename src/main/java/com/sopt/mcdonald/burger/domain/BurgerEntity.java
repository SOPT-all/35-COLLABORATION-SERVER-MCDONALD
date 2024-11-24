package com.sopt.mcdonald.burger.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table(name = "burger")
public class BurgerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long burgerId;
    @Column(nullable = false, length = 255)
    private String burgerName;

    @Column(nullable = false, length = 255)
    private String burgerNameEng;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(name = "weight_g")
    private Integer weightG;

    @Column(name = "weight_ml")
    private Integer weightMl;

    @Column(name = "calories")
    private Integer calories;

    @Column(name = "sugar")
    private Integer sugar;

    @Column(name = "protein")
    private Integer protein;

    @Column(name = "saturated_fat")
    private Integer saturatedFat;

    @Column(name = "sodium")
    private Integer sodium;

    @Column(name = "caffeine")
    private Integer caffeine;

    @OneToMany(mappedBy = "burgerEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AllergyEntity> allergies;

    @Column(nullable = false, length = 255)
    private String origin;

    @Column(nullable = false)
    private Boolean isLiked=false;
}
