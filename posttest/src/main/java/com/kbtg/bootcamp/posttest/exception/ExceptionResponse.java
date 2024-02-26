package com.kbtg.bootcamp.posttest.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionResponse {
    private String message;
    private HttpStatus httpStatus;
    private String httpStatusCode;


    public ExceptionResponse(String message, HttpStatus httpStatus, String httpStatusCode) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatusCode;
    }
}
