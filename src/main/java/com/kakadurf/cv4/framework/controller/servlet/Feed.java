package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.service.MusicService;
import com.kakadurf.cv4.framework.data.dto.MusicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@PreAuthorize("isAuthenticated()")
public class Feed {
    @Autowired
    MusicService musicService;
    @GetMapping("/feed")
    public String getFeed(@RequestParam long id, Model model){
        List<MusicDto> list = musicService.getOnesMusic(id);

        model.addAttribute("music_list",list);
        return "music_library";
    }
}
