package com.kakadurf.cv4.framework.controller.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

@PermitAll
@Controller
public class MainPage {
    @GetMapping("/main_page")
    public String getMainPage(){
        return "main_page";
    }
}
