package com.sopt.mcdonald.news.integration;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import com.sopt.mcdonald.news.domain.News;
import com.sopt.mcdonald.news.repository.NewsRepository;
import io.restassured.RestAssured;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class NewsIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private NewsRepository newsRepository;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        News news1 = new News("첫번째");
        News news2 = new News("두번째");
        News news3 = new News("세번째");
        News news4 = new News("네번째");
        News news5 = new News("다섯번째");
        News news6 = new News("여섯번째");
        News news7 = new News("일곱번째");
        newsRepository.saveAll(List.of(news1, news2, news3, news4, news5, news6, news7));
    }

    @DisplayName("cursor와 size를 이용하여 News를 조회할 수 있다.")
    @Test
    void getNewsWithCursorAndSize() {
        RestAssured.given()
                .queryParam("cursor", 1)
                .queryParam("size", 2)
                .when().get("/news")
                .then().statusCode(HttpStatus.OK.value())
                .body("news", hasSize(2))
                .body("news[0].id", is(2))
                .body("news[0].content", is("두번째"))
                .body("news[1].id", is(3))
                .body("news[1].content", is("세번째"));
    }

    @DisplayName("cursor, size 없이 News를 조회할 경우, 기본적으로 6개의 News를 조회한다.")
    @Test
    void getNewsWithCursor() {
        RestAssured.given()
                .when().get("/news")
                .then().statusCode(HttpStatus.OK.value())
                .body("news", hasSize(6))
                .body("news[0].id", is(1))
                .body("news[0].content", is("첫번째"))
                .body("news[1].id", is(2))
                .body("news[1].content", is("두번째"))
                .body("news[2].id", is(3))
                .body("news[2].content", is("세번째"))
                .body("news[3].id", is(4))
                .body("news[3].content", is("네번째"))
                .body("news[4].id", is(5))
                .body("news[4].content", is("다섯번째"))
                .body("news[5].id", is(6))
                .body("news[5].content", is("여섯번째"));
    }

    @Test
    void getNewsWithInvalidCursor() {
        RestAssured.given()
                .queryParam("cursor", -1)
                .when()
                .get("/news")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("message", containsString("광고의 식별값은 양수로 이루어져야 합니다."));
    }
}
