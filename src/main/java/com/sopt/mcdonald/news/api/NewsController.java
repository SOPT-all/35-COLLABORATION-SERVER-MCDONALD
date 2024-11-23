package com.sopt.mcdonald.news.api;

import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sopt.mcdonald.news.dto.NewsResponses;
import com.sopt.mcdonald.news.service.NewsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
@Validated
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<NewsResponses> getNews(@RequestParam(name = "cursor", defaultValue = "0")
                                                 @Min(value = 0, message = "광고의 식별값은 양수로 이루어져야 합니다.")
                                                 long newsId,
                                                 @RequestParam(defaultValue = "6", required = false) int size) {
        NewsResponses news = newsService.getNews(newsId, size);
        return ResponseEntity.ok(news);
    }
}
