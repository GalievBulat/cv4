package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.service.interfaces.UserSearchService;
import com.kakadurf.cv4.framework.data.dto.UserDto;
import com.kakadurf.cv4.framework.data.dto.UserSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsersSearchPage {
    @Autowired
    UserSearchService searchService;

    @GetMapping("/search")
    public String getSearchPage(Model model,
                                UserSearchForm searchForm,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10" ) int size){
        List<UserDto> userDtos = searchService.findByData(searchForm, PageRequest.of(page-1, size));
        model.addAttribute("users_list", userDtos);
        return "users_search";
    }
}
