package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.entities.UserData;
import com.kakadurf.cv4.domain.service.MailService;
import com.kakadurf.cv4.domain.service.RegistrationService;
import com.kakadurf.cv4.domain.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.Random;
import java.util.UUID;

@PermitAll
@Controller
public class Registration{
    static UserData user;
    static int code;
    @Autowired
    private SmsService smsSender;

    @GetMapping("/reg")
    public String getPage(Model model) {
        model.addAttribute("userData",new UserData());
        return "registration";
    }
    @PostMapping("/reg")
    public String getUser(@Valid UserData user,
                          BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            Registration.code = new Random().nextInt();
            Registration.user = user;
            smsSender.sendSms(user.getPhone_num(), code + "");
            return "redirect:/registration_confirmation";
        } else {
            return "registration";
        }
    }
}
