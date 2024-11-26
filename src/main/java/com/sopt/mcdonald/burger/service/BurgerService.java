package com.sopt.mcdonald.burger.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.sopt.mcdonald.burger.api.dto.response.BurgerResponse;
import com.sopt.mcdonald.burger.api.dto.response.BurgerResponses;
import com.sopt.mcdonald.burger.domain.BurgerEntity;
import com.sopt.mcdonald.burger.domain.Category;
import com.sopt.mcdonald.burger.repository.BurgerRepository;
import com.sopt.mcdonald.global.exception.McdonaldException;

@Component
public class BurgerService {
    private final BurgerRepository burgerRepository;

    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    @Transactional(readOnly = true)
    public BurgerResponse getBurgerDetails(long burgerId) {
        BurgerEntity burgerEntity = burgerRepository.findById(burgerId)
                .orElseThrow(() -> new McdonaldException("버거 id를 찾을 수 없습니다.", HttpStatus.NOT_FOUND));
        return BurgerResponse.of(burgerEntity);
    }

    @Transactional
    public void updateLikeStatus(long burgerId) {
        BurgerEntity burgerEntity = burgerRepository.findById(burgerId)
                .orElseThrow(() -> new McdonaldException("버거 id를 찾을 수 없습니다.", HttpStatus.NOT_FOUND));
        burgerEntity.switchLiked();
    }

    @Transactional(readOnly = true)
    public BurgerResponses getBurgerByCategory(Category category) {
        if (Category.ALL == category) {
            List<BurgerEntity> all = burgerRepository.findAll();
            return BurgerResponses.from(all);
        }
        List<BurgerEntity> burgers = burgerRepository.findByCategory(category);
        return BurgerResponses.from(burgers);
    }
}
