package com.sopt.mcdonald.burger.repository;

import com.sopt.mcdonald.burger.domain.BurgerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BurgerRepository extends JpaRepository<BurgerEntity, Long> {
    Optional<BurgerEntity> findById(Long burgerId);
}


