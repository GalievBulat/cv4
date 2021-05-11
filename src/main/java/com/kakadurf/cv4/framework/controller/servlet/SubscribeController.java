package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.datasource.SubscribeSource;
import com.kakadurf.cv4.domain.service.UserManagingService;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@PreAuthorize("isAuthenticated()")
@Controller
public class SubscribeController {
    @Autowired
    UserManagingService userManagingService;
    @GetMapping("/subscribe/{id}")
    public String subscribe(@AuthenticationPrincipal UserDetailsImpl security,
                            @PathVariable("id") long id){
        userManagingService.subscribeToUser(security.user.getId(), id);
        return "redirect:/feed";
    }

}
