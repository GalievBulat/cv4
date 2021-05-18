package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.UserData;
import com.kakadurf.cv4.domain.service.interfaces.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.Random;

@PermitAll
@Controller
public class Registration{
    static UserData user;
    static int code;

    @Autowired
    private SmsService smsSender;

    @Autowired
    private UserSource userSource;
    @GetMapping("/reg")
    public String getPage(Model model) {
        model.addAttribute("userData",new UserData());
        return "registration";
    }
    @PostMapping("/reg")
    public String getUser(@Valid UserData user,
                          BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            if (!userSource.findByEmail(user.getEmail()).isPresent()) {
                Registration.code = new Random().nextInt(9999);
                Registration.user = user;
                smsSender.sendSms(user.getPhone_num(), code + "");
                return "redirect:/registration_confirmation";
            }
            bindingResult.rejectValue("email", "email.not.unique", "not unique email");
        }
        return "registration";
    }
}
