package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.service.UserManagingService;
import com.kakadurf.cv4.framework.data.dto.UserDto;
import com.kakadurf.cv4.framework.data.dto.UserSearchForm;
import javassist.NotFoundException;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@PreAuthorize("isAuthenticated()")
public class UsersPage {
    @Autowired
    UserManagingService managingService;
    @GetMapping("/user/{id}")
    public String getSearchPage(@PathVariable("id") long id,
                                Model model){
        UserDto user = managingService.findUser(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,""));
        model.addAttribute("user",user);
        return "users_page";
    }
}