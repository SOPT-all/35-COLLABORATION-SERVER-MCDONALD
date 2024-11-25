package com.sopt.mcdonald.burger.repository;

import com.sopt.mcdonald.burger.domain.BurgerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BurgerRepository extends JpaRepository<BurgerEntity, Long> {
}


