package com.sopt.mcdonald.burger.api;

import com.sopt.mcdonald.burger.api.dto.response.ApiResponse;
import com.sopt.mcdonald.burger.api.dto.response.BurgerResponse;
import com.sopt.mcdonald.burger.api.dto.response.FavoriteListResponse;
import com.sopt.mcdonald.burger.service.BurgerService;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class BurgerController {
    private final BurgerService burgerService;

    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @GetMapping("/burgers/{burgerId}")
    public ResponseEntity<BurgerResponse> getBurgerDetail(@PathVariable @Min(value = 1, message = "버거 id는 양수값이어야 합니다.") Long burgerId) {
        BurgerResponse burgerResponse = burgerService.getBurgerDetails(burgerId);
        return ResponseEntity.ok(burgerResponse);
    }

    @PostMapping("/favorites/{burgerId}")
    public ResponseEntity<ApiResponse> postLike(@PathVariable @Min(value = 1, message = "버거 id는 양수값이어야 합니다.") Long burgerId) {
        burgerService.updateLikeStatus(burgerId);
        ApiResponse successResponse = new ApiResponse(HttpStatus.OK.toString(), "요청이 성공했습니다.");
        return ResponseEntity.ok(successResponse);
    }
}
