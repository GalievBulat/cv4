package com.kakadurf.cv4.framework_presentation.controller;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@PreAuthorize("isAuthenticated()")
@Controller
public class Search {
    @Autowired
    UserSource userSource;

    private final int size = 10;

    @GetMapping("/search")
    public String getSearchPage(){
        return "routes";
    }

    @PostMapping("/search")
    @ResponseBody
    public String search(@RequestBody String name, @RequestParam int page){
        return userSource.findUsersByEmail(name, PageRequest.of(--page, size))
                .stream()
                .map(UserEntity::toJSON)
                .collect(Collectors.toList())
                .toString();
    }
}
