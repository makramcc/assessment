package com.kbtg.bootcamp.posttest.controller;

import com.kbtg.bootcamp.posttest.exception.AlreadyExistsException;
import com.kbtg.bootcamp.posttest.exception.ValidationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseController {
    public void validateData(BindingResult result){
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            String msg = result.getFieldErrors().get(0).getDefaultMessage();
            throw new ValidationException(msg);
        }
    }
}
