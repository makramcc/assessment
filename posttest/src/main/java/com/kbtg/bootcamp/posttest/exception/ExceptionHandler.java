package com.kbtg.bootcamp.posttest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {AlreadyExistsException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleAlreadyExistException(AlreadyExistsException alreadyExistsException){
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        return new ResponseEntity<>(new ExceptionResponse(
                    alreadyExistsException.getMessage(),
                    httpStatus,
                    Integer.toString(httpStatus.value())

                ),
                httpStatus);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ExceptionResponse(
                notFoundException.getMessage(),
                httpStatus,
                Integer.toString(httpStatus.value())

        ),
                httpStatus);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleValidationException(ValidationException validationException){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ExceptionResponse(
                validationException.getMessage(),
                httpStatus,
                Integer.toString(httpStatus.value())

        ),
                httpStatus);
    }
}
