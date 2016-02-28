package com.deepan.bmw.studentinfo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Deepan Sathyamoorthy
 * on 2/28/16.
 */
@ControllerAdvice
public class ErrorHandler {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid argument")
    @ExceptionHandler(IllegalArgumentException.class)
    public String responseInvalidArgument(IllegalArgumentException e) {
        return e.getMessage();
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String responseException() {
        return "Error occured while processing the reques. Please contact support";
    }
}
