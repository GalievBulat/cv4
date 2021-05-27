package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.service.interfaces.MailService;
import com.kakadurf.cv4.domain.service.interfaces.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.PermitAll;
import java.util.UUID;

import static com.kakadurf.cv4.framework.controller.servlet.RegistrationPage.user;

@PermitAll
@Controller
public class RegistrationConfirmation {
    @Autowired
    private RegistrationService regHandler;

    @Autowired
    private MailService emailSender;

    @GetMapping("/registration_confirmation")
    public String getRegConfirmationPage() {
        return "registration_confirmation";
    }
    @PostMapping("/registration_confirmation")
    public String confirmUser(@RequestParam int code){
        if (user != null && user.getEmail() != null){
            if (code == RegistrationPage.code) {
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
