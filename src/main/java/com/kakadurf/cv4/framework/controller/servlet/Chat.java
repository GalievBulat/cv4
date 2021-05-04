package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Chat {
    @GetMapping("/chat")
    public String getPage(Model model, @AuthenticationPrincipal UserDetailsImpl security){
        //model.addAttribute("",security.user.)
        return "forum";
    }
}