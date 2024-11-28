package com.sopt.mcdonald.burger.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sopt.mcdonald.burger.domain.BurgerEntity;
import com.sopt.mcdonald.burger.domain.Category;
import com.sopt.mcdonald.burger.domain.Type;


public interface BurgerRepository extends JpaRepository<BurgerEntity, Long> {

    List<BurgerEntity> findByIsLikedTrue();

    List<BurgerEntity> findByType(Type type);

    List<BurgerEntity> findByCategoryAndType(Category category, Type type);
}


