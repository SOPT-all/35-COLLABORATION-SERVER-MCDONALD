package com.sopt.mcdonald.burger.service;

import com.sopt.mcdonald.burger.api.dto.response.BurgerResponse;
import com.sopt.mcdonald.burger.domain.BurgerEntity;
import com.sopt.mcdonald.burger.repository.BurgerRepository;
import com.sopt.mcdonald.global.exception.McdonaldException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class BurgerService {
    private final BurgerRepository burgerRepository;

    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    @Transactional(readOnly = true)
    public BurgerResponse getBurgerDetails(long burgerId) {
        BurgerEntity burgerEntity = burgerRepository.findById(burgerId)
                .orElseThrow(()-> new McdonaldException("버거 id를 찾을 수 없습니다.", HttpStatus.NOT_FOUND));
        return BurgerResponse.of(burgerEntity);
    }

    @Transactional
    public void updateLikeStatus(long burgerId) {
        BurgerEntity burgerEntity = burgerRepository.findById(burgerId)
                .orElseThrow(()-> new McdonaldException("버거 id를 찾을 수 없습니다.", HttpStatus.NOT_FOUND));
        burgerEntity.setLiked(!burgerEntity.getIsLiked());
        burgerRepository.save(burgerEntity);
        BurgerResponse.of(burgerEntity);
    }
}
