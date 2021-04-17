package com.kakadurf.cv4.framework_presentation.controller;

import com.kakadurf.cv4.domain.entities.FileEntity;
import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.domain.service.FileHandlingService;
import com.kakadurf.cv4.framework_presentation.data.MultipartFileFacade;
import com.kakadurf.cv4.framework_presentation.db_interface.MusicRepository;
import com.kakadurf.cv4.framework_presentation.security.UserDetailsImpl;
import com.kakadurf.cv4.framework_presentation.service.FileThrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@PreAuthorize("isAuthenticated()")
@Controller
public class MusicPage {
    @Autowired
    MusicRepository musicRepository;
    @Autowired
    FileHandlingService fileHandlingService;

    @Autowired
    FileThrower fileThrower;
    @PostMapping("/save_music")
    @Transactional
    public String saveMusic(@RequestParam("file") MultipartFile file,
                            @AuthenticationPrincipal UserDetailsImpl security,
                            MusicEntity entity){
        if (file.getContentType().contains("audio/mpeg")) {
            FileEntity musicFile = fileHandlingService.saveFile(new MultipartFileFacade(file));
            //TODO(refactor)
            musicFile.setOwner(security.user);
            entity.setMusicFile(musicFile);
            musicRepository.save(entity);
        }
        return "redirect:/music_saving";
    }

    @GetMapping("/save_music")
    public String getPage(){
        return "music_saving";
    }
}
