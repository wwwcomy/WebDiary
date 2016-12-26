package com.iteye.wwwcomy.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.iteye.wwwcomy.model.ValidationErrorMessage;

@ControllerAdvice
public class ErrorHandling {
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ValidationErrorMessage handle(NullPointerException ex, HttpServletResponse response) {
        ValidationErrorMessage message = new ValidationErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return message;
    }
}
