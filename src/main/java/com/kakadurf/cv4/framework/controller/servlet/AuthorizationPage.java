package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.service.JwtTokenizer;
import com.kakadurf.cv4.domain.service.MessageService;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

@PermitAll
@Controller
public class AuthorizationPage {
    @GetMapping("/auth")
    public String getAuthPage(){
       return "auth2";
    }

}
