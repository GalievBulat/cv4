package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.entities.UserData;
import com.kakadurf.cv4.domain.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

@PermitAll
@Controller
public class Registration{
    @Autowired
    private RegistrationService regHandler;

    @Autowired
    private MailSender emailSender;

    @GetMapping("/reg")
    public String getPage(Model model) {
        model.addAttribute("userData",new UserData());
        return "registration";
    }
    @PostMapping("/reg")
    public String getUser(@Valid UserData user,
                          BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            regHandler.signUp(user);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("noreply@kakadurf.com");
            message.setTo(user.getEmail());
            message.setSubject("subject");
            message.setText("text");
            emailSender.send(message);
            return "redirect:/auth";
        } else {
            return "registration";
        }
    }
}
