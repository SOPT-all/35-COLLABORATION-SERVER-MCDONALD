package com.sopt.mcdonald.burger.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "allergy")
public class AllergyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "burger_id", nullable = false)
    private BurgerEntity burgerEntity;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "allergy_name", nullable = false)
    private Allergy allergyName;

}

