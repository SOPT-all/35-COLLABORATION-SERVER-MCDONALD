package com.sopt.mcdonald.news.dto;

import com.sopt.mcdonald.news.domain.News;

public record NewsResponse(long id, String content) {

    public NewsResponse(News news) {
        this(news.getId(), news.getContent());
    }
}
