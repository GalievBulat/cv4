package com.kakadurf.cv4.framework.config.exceptions;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AccessDeniedException {
    @ExceptionHandler(org.springframework.security.access.AccessDeniedException.class)
    public String handle(Exception e) throws Exception {
        return "redirect:/auth";
    }
}
