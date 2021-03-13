package com.kakadurf.cv4.framework_presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPage {
    @GetMapping("/main")
    public String getMainPage(){
        return "main_page";
    }
}
