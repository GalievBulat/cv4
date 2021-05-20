package com.kakadurf.cv4.framework.config.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class NoHandlerFoundExceptionHandler {
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle(Exception e) throws Exception {
        return "redirect:/auth";
    }
}
