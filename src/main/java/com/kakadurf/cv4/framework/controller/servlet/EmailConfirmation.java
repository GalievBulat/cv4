package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@PreAuthorize("isAuthenticated()")
@Controller
public class EmailConfirmation {
    @Autowired
    private UserSource userSource;

    @GetMapping("/email_confirm/{code}")
    public String getConfirmationPage(@PathVariable("code") String code,
                                      @AuthenticationPrincipal UserDetailsImpl userDetails) {
        UserEntity user = userDetails.user;
        if (user == null){
            return "redirect:/auth";
        }
        if (code.equals(user.getEmailCode()) &&  user.getState() == UserEntity.State.NON_CONFIRMED){
            userDetails.user.setState(UserEntity.State.ACTIVE);
            userSource.save(user);
        }

        return "redirect:/profile";
    }

}
