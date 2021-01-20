package com.oktenweb.springbootstpr.controllers;

import com.oktenweb.springbootstpr.dao.BadRequestException;
import com.oktenweb.springbootstpr.dto.ResponseErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ErrorController {
                            // capital letter / duration
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseErrorDto handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error("handle MethodArgumentNotValidException with movie: {} ", exception.getMessage());
        String message = parseValidationException(exception);
        return new ResponseErrorDto(LocalDateTime.now(), message, HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseErrorDto handleBadRequestException(BadRequestException exception) {
        log.error("handle BadRequestException with movie: {} ", exception.getMessage());
        return new ResponseErrorDto(LocalDateTime.now(), exception.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    private String parseValidationException(MethodArgumentNotValidException exception) {
        List<String> defaultMessages = exception.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return defaultMessages.toString();
    }
}
