package com.kakadurf.cv4.framework.controller.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Chat {
    @GetMapping("/chat")
    public String getPage(){
        return "forum";
    }
}
