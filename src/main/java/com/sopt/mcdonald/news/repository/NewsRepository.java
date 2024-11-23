package com.sopt.mcdonald.news.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sopt.mcdonald.news.domain.News;

public interface NewsRepository extends JpaRepository<News, Integer> {

    @Query("SELECT n FROM News n WHERE n.id > :cursor ORDER BY n.id ASC LIMIT :size")
    List<News> findNewsAfterCursor(@Param("cursor") long cursor, @Param("size") int size);
}
