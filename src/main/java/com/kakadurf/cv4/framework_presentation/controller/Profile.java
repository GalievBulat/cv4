package com.kakadurf.cv4.framework_presentation.controller;

import com.kakadurf.cv4.domain.service.DataMapper;
import com.kakadurf.cv4.framework_presentation.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@PreAuthorize("isAuthenticated()")
@Controller
public class Profile {


    @GetMapping("/profile")
    public String getProfile(Model model, @AuthenticationPrincipal UserSecurity security){
        //DataMapper.INSTANCE.userDataToEntity(security.user)

        model.addAttribute("user",security.user);
        /*Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("tc")){
                Optional<UserEntity> userEntity = authService.connectByTocken(Long.parseLong(cookie.getValue()));
                userEntity.ifPresent((UserEntity ent )-> model.addAttribute("user", ent));
            }
        }*/
        return "profile";
    }
}
