package com.example.organizationcrud.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ExceptionResponse {
    private HttpStatus httpStatus;
    private String message;
    private String exceptionClassName;

    public ExceptionResponse(HttpStatus httpStatus, String message, String exceptionClassName) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.exceptionClassName = exceptionClassName;
    }
}
