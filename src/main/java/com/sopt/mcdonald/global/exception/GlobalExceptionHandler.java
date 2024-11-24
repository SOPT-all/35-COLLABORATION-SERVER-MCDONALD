package com.sopt.mcdonald.global.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import com.sopt.mcdonald.global.message.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        String exceptionMessage = "올바르지 않은 쿼리 파라미터 형식입니다.";
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST.toString(), exceptionMessage);
        log.warn("exception Message : {},\n exceptionStackTrace : {}", e.getMessage(), e.getStackTrace());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(McdonaldException.class)
    public ResponseEntity<ExceptionResponse> handleMcdonaldException(McdonaldException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
        log.warn("exception Message : {},\n exceptionStackTrace : {}", e.getMessage(), e.getStackTrace());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> handleConstraintViolationException(ConstraintViolationException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
        log.warn("exception Message : {},\n exceptionStackTrace : {}", e.getMessage(), e.getStackTrace());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        String exceptionMessage = "해당하는 버거 ID를 찾을 수 없습니다.";
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.toString(), e.getMessage());
        log.warn("exception Message : {},\n exceptionStackTrace : {}", e.getMessage(), e.getStackTrace());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handleInternalServerErrorException(RuntimeException e) {
        String exceptionMessage = "예기치 못한 서버 오류입니다. 다시 시도해주세요.";
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), exceptionMessage);
        log.error("exception Message : {},\n exceptionStackTrace : {}", e.getMessage(), e.getStackTrace());
        return ResponseEntity.internalServerError().body(exceptionResponse);
    }
}
