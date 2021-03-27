package com.kakadurf.cv4.framework_presentation.controller;

import com.kakadurf.cv4.domain.entities.UserData;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.domain.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Registration{
    @Autowired
    private RegistrationService regHandler;
    @GetMapping("/reg")
    public String getPagee(){
        return "registration";
    }
    @PostMapping("/reg")
    public String getUser(UserData user){
        regHandler.signUp(user);
        return "redirect:/auth";
    }
}
