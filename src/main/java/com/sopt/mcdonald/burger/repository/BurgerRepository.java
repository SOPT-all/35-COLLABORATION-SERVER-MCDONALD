package com.sopt.mcdonald.burger.repository;

import com.sopt.mcdonald.burger.domain.BurgerEntity;
import com.sopt.mcdonald.burger.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BurgerRepository extends JpaRepository<BurgerEntity, Long> {
    List<BurgerEntity> findByIsLikedTrue();
    List<BurgerEntity> findByCategory(Category category);
}


