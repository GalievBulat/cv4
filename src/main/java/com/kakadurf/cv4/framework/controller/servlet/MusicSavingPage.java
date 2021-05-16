package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.domain.service.MusicService;
import com.kakadurf.cv4.framework.data.MultipartFileFacade;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@PreAuthorize("isAuthenticated()")
@Controller
public class MusicSavingPage {
    @Autowired
    MusicService musicService;
    @PostMapping("/save_music")
    @Transactional
    public String saveMusic(@RequestParam("file") MultipartFile file,
                            @AuthenticationPrincipal UserDetailsImpl security,
                            MusicEntity entity){
        if (musicService.uploadMusic(entity, new MultipartFileFacade(file), security.user))
            return "success";
        else
            return "redirect:/error";
    }

    @GetMapping("/save_music")
    public String getPage(){
        return "music_saving";
    }
}
