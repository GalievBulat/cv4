package com.kakadurf.cv4.presentation.controller;

import com.kakadurf.cv4.domain.facade.AuthService;
import com.kakadurf.cv4.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class Profile {
    @Autowired
    private AuthService authService;
    @GetMapping("/profile")
    public String getProfile(Model model, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("tc")){
                Optional<UserEntity> userEntity = authService.connectByTocken(Long.parseLong(cookie.getValue()));
                userEntity.ifPresent((UserEntity ent )-> model.addAttribute("user", ent));
            }
        }
        return "profile";
    }
}
