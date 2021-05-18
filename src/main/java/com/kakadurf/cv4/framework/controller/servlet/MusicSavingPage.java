package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.entities.FileEntity;
import com.kakadurf.cv4.domain.entities.MusicInfo;
import com.kakadurf.cv4.domain.entities.RowFileData;
import com.kakadurf.cv4.domain.service.interfaces.FileHandlingService;
import com.kakadurf.cv4.domain.service.interfaces.MailService;
import com.kakadurf.cv4.domain.service.interfaces.MusicService;
import com.kakadurf.cv4.domain.service.interfaces.UserManagingService;
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

import javax.validation.Valid;

@PreAuthorize("isAuthenticated()")
@Controller
public class MusicSavingPage {
    @Autowired
    MusicService musicService;

    @Autowired
    FileHandlingService fileHandlingService;

    @Autowired
    UserManagingService userManagingService;

    @Autowired
    MailService mailService;

    @PostMapping("/save_music")
    @Transactional
    public String saveMusic(@RequestParam("file") MultipartFile file,
                            @AuthenticationPrincipal UserDetailsImpl security,
                            @Valid MusicInfo entity){
        if (file.getContentType().contains("audio/mpeg")) {
            RowFileData fileFacade = new MultipartFileFacade(file);
            //TODO(dodumat)
            FileEntity musicFile = fileHandlingService.saveFile(fileFacade, security.user);
            musicService.uploadMusic(entity,musicFile, security.user);
            userManagingService.getSubscribers(security.user).forEach(subscribe ->
                    mailService.sendMail(subscribe.getSubscriber().getEmail(),
                            "new music upload by " + security.user.getName(),
                            entity.getName()));
            return "success";
        }
        return "redirect:/error";
    }

    @GetMapping("/save_music")
    public String getPage(){
        return "music_saving";
    }
}
