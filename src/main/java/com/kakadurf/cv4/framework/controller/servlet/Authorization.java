package com.kakadurf.cv4.framework.controller.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

@PermitAll
@Controller
public class Authorization {
    @GetMapping("/auth")
    public String getPage(){
        return "auth";
    }

}
