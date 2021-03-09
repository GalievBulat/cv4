package com.kakadurf.cv4.presentation.controller;

import com.kakadurf.cv4.data.dto.UserForm;
import com.kakadurf.cv4.domain.facade.RegistrationService;
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
    public String getUser(UserForm user){
        regHandler.signUp(user);
        return "redirect:/auth";
    }
}
