package com.sopt.mcdonald.burger.service;

import com.sopt.mcdonald.burger.api.dto.response.BurgerResponse;
import com.sopt.mcdonald.burger.domain.BurgerEntity;
import com.sopt.mcdonald.burger.repository.BurgerRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BurgerService {
    private final BurgerRepository burgerRepository;

    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    @Transactional
    public BurgerResponse getBurgerDetails(long burgerId) {
        BurgerEntity burgerEntity = burgerRepository.findById(burgerId)
                .orElseThrow(()-> new IllegalArgumentException("버거 id를 찾을 수 없습니다."));
        return BurgerResponse.of(burgerEntity);
    }

}
