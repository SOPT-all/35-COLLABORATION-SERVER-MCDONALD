package com.sopt.mcdonald.burger.api;

import com.sopt.mcdonald.burger.api.dto.response.BurgerResponse;
import com.sopt.mcdonald.burger.service.BurgerService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/burgers")
@Validated
public class BurgerController {
    private final BurgerService burgerService;

    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @GetMapping("/{burgerId}")
    public ResponseEntity<BurgerResponse> getBurgerDetail(@PathVariable @Min(value = 0, message = "버거 id는 양수값이어야 합니다.") Long burgerId) {
        BurgerResponse burgerResponse = burgerService.getBurgerDetails(burgerId);
        return ResponseEntity.ok(burgerResponse);
    }
}
