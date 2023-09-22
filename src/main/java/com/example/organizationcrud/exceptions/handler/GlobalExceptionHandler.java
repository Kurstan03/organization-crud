package com.example.organizationcrud.exceptions.handler;

import com.example.organizationcrud.exceptions.BadRequestException;
import com.example.organizationcrud.exceptions.ExceptionResponse;
import com.example.organizationcrud.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse badRequestException(BadRequestException badRequestException) {
        return new ExceptionResponse(
                HttpStatus.BAD_REQUEST,
                badRequestException.getMessage(),
                badRequestException.getClass().getSimpleName());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse notFoundException(NotFoundException n) {
        return new ExceptionResponse(
                HttpStatus.NOT_FOUND,
                n.getMessage(),
                n.getClass().getSimpleName());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse methodArgumentNotValid(MethodArgumentNotValidException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(Objects.requireNonNull(exception.getFieldError()).getDefaultMessage())
                .build();
    }
}
