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
    /*@PostMapping("/auth")
    public String authorize(UserInfo userInfo, HttpServletResponse response){
        Optional<UserEntity> entity = authService.authorize(userInfo.getTc(), userInfo.getPassword());
        System.out.println(entity);
        if (entity.isPresent()) {
            Cookie cookie = new Cookie("tc", "" + userInfo.getTc());
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
        }
        return "redirect:/profile";
    }*/
}
