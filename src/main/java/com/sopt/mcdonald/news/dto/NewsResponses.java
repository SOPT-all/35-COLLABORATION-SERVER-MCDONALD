package com.sopt.mcdonald.news.dto;

import java.util.List;
import com.sopt.mcdonald.news.domain.News;

public record NewsResponses(List<NewsResponse> news) {

    public static NewsResponses from(List<News> news) {
        List<NewsResponse> responses = news.stream().map(NewsResponse::new).toList();
        return new NewsResponses(responses);
    }
}
