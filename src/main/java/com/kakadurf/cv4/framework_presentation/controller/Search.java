package com.kakadurf.cv4.framework_presentation.controller;

import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.domain.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.function.Consumer;

@PreAuthorize("isAuthenticated()")
@Controller
public class Search {
    @Autowired
    SearchService searchService;
    @GetMapping("/search")
    public String getSearchPage(){
        return "routes";
    }
    @ResponseBody
    @PostMapping("/search")
    public String search(@RequestBody String name){
        return searchService.searchForUsers(name, 10,1).orElseThrow(RuntimeException::new).toString();
    }
}
