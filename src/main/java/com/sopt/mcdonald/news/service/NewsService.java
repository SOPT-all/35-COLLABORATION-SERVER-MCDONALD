package com.sopt.mcdonald.news.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sopt.mcdonald.news.domain.News;
import com.sopt.mcdonald.news.dto.NewsResponses;
import com.sopt.mcdonald.news.repository.NewsRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsResponses getNews(long newsId, int size) {
        List<News> news = newsRepository.findNewsAfterCursor(newsId, size);
        return NewsResponses.from(news);
    }
}
