package com.sopt.mcdonald.burger.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse {
    private String status;
    private String message;
}
