package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.service.JwtTokenizer;
import com.kakadurf.cv4.domain.service.MessageService;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("isAuthenticated()")
public class ChatPage {
    @Autowired
    MessageService messageService;

    @Autowired
    JwtTokenizer jwtTokenizer;
    @GetMapping("/chat")
    public String getChatPage(Model model, @AuthenticationPrincipal UserDetailsImpl security){
        model.addAttribute("token", jwtTokenizer.getToken(security.user.getId(), security.user.getName()));
        model.addAttribute("username", security.user.getName());
        model.addAttribute("messages",messageService.getOnesMessages(security.user));
        return "forum";
    }
}
