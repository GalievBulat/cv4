package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.entities.UserData;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.domain.service.MailService;
import com.kakadurf.cv4.domain.service.RegistrationService;
import com.kakadurf.cv4.domain.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.UUID;

import static com.kakadurf.cv4.framework.controller.servlet.Registration.user;

@PermitAll
@Controller
public class RegistrationConfirmation {
    @Autowired
    private RegistrationService regHandler;

    @Autowired
    private MailService emailSender;

    @GetMapping("/registration_confirmation")
    public String getPage() {
        return "registration_confirmation";
    }
    @PostMapping("/registration_confirmation")
    public String getUser(@RequestParam int code){
        if (user != null && user.getEmail() != null){
            if (code == Registration.code) {
                String emailCode = UUID.randomUUID().toString();
                regHandler.signUp(user, emailCode);
                emailSender.sendMail(user.getEmail(), "confirmation",
                        "open this link : http:/localhost/email_confirm/" + emailCode);
                user = null;
                return "redirect:/auth";
            } else
                return "redirect:/registration_confirmation";
        } else
            return "redirect:/auth";
    }
}