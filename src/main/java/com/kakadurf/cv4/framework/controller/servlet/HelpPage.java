package com.kakadurf.cv4.framework.controller.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;
@PermitAll
@Controller
public class HelpPage{
    @GetMapping("/help")
    public String getHelpPage(){
        return "help";
    }
}
