package com.kakadurf.cv4.presentation.controller;

import com.kakadurf.cv4.domain.UserEntity;
import com.kakadurf.cv4.data.dto.UserInfo;
import com.kakadurf.cv4.data.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class Authorization {
    @Autowired
    private AuthService authService;
    @GetMapping("/auth")
    public String getPage(){
        return "auth";
    }
    @PostMapping("/auth")
    public String authorize(UserInfo userInfo, HttpServletResponse response){
        Optional<UserEntity> entity = authService.authorize(userInfo.getTc(), userInfo.getPassword());
        System.out.println(entity);
        if (entity.isPresent()) {
            Cookie cookie = new Cookie("tc", "" + userInfo.getTc());
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
        }
        return "redirect:/profile";
    }
}
