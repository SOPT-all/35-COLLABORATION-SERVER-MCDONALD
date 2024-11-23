package com.sopt.mcdonald.news.repository;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.sopt.mcdonald.news.domain.News;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
class NewsRepositoryTest {

    @Autowired
    private NewsRepository newsRepository;

    @DisplayName("cursor와 size를 기준으로 News를 조회할 수 있다.")
    @Test
    void findNewsAfterCursor() {
        saveDummyData();

        List<News> news = newsRepository.findNewsAfterCursor(2, 2);
        assertAll(
                () -> assertThat(news.size()).isEqualTo(2),
                () -> assertThat(news.get(0).getId()).isEqualTo(3),
                () -> assertThat(news.get(0).getContent()).isEqualTo("세번째"),
                () -> assertThat(news.get(1).getId()).isEqualTo(4),
                () -> assertThat(news.get(1).getContent()).isEqualTo("네번째")
        );
    }

    private void saveDummyData() {
        News news1 = new News("첫번째");
        News news2 = new News("두번째");
        News news3 = new News("세번째");
        News news4 = new News("네번째");
        newsRepository.saveAll(List.of(news1, news2, news3, news4));
    }
}
