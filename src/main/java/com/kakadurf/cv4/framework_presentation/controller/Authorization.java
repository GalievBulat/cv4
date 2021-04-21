package com.kakadurf.cv4.framework_presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
