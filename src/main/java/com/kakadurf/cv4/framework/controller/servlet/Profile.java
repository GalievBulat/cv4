package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.entities.UserData;
import com.kakadurf.cv4.domain.service.interfaces.MailService;
import com.kakadurf.cv4.domain.service.interfaces.UserManagingService;
import com.kakadurf.cv4.framework.data.transport.UserMapper;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@PreAuthorize("isAuthenticated()")
@Controller
public class Profile {
    @Autowired
    UserManagingService editorService;
    @Autowired
    UserManagingService userManagingService;

    @Autowired
    MailService mailService;

    @GetMapping("/profile")
    public String getProfile(Model model, @AuthenticationPrincipal UserDetailsImpl security){
        model.addAttribute("user", UserMapper.INSTANCE.userToDto(security.user));
        return "profile";
    }
    @PostMapping("/profile")
    public String editPageProfile(UserData data, @AuthenticationPrincipal UserDetailsImpl security){
        security.user.setName(data.getName());
        security.user.setSurname(data.getSurname());
        editorService.replaceUser(security.user);
        return "redirect:/profile";
    }
}
