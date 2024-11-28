package com.sopt.mcdonald.burger.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sopt.mcdonald.burger.domain.BurgerEntity;
import com.sopt.mcdonald.burger.domain.Category;
import com.sopt.mcdonald.burger.domain.Type;


public interface BurgerRepository extends JpaRepository<BurgerEntity, Long> {

    List<BurgerEntity> findByIsLikedTrue();

    @Query(value = """
            SELECT *
            FROM burger
            WHERE type = :type
              AND burger_id > :burgerId
            ORDER BY burger_id ASC
            LIMIT :size
            """, nativeQuery = true)
    List<BurgerEntity> findByTypeWithCursor(
            @Param("type") String type,
            @Param("burgerId") long burgerId,
            @Param("size") int size
    );

    @Query(value = """
        SELECT *
        FROM burger
        WHERE category = :category
          AND type = :type
          AND burger_id > :burgerId
        ORDER BY burger_id ASC
        LIMIT :size
        """, nativeQuery = true)
    List<BurgerEntity> findByCategoryAndTypeWithCursor(
            @Param("category") String category,
            @Param("type") String type,
            @Param("burgerId") long burgerId,
            @Param("size") int size
    );

}


