package com.kakadurf.cv4.framework_presentation.controller;

import com.kakadurf.cv4.domain.datasource.MusicSource;
import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.domain.service.MusicService;
import com.kakadurf.cv4.domain.service.MusicServiceImpl;
import com.kakadurf.cv4.framework_presentation.db_interface.MusicRepository;
import com.kakadurf.cv4.framework_presentation.transport.MusicDto;
import com.kakadurf.cv4.framework_presentation.transport.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

//@PreAuthorize("isAu")
@Controller
public class MusicListing {


    @Autowired
    MusicService musicService;

    @GetMapping("/music")
    public String getSearchPage(Model model,
                                @RequestParam(required = false, defaultValue = "0") int page,
                                @RequestParam(required = false, defaultValue = "10" ) int size){
        /*
        if (currentPage == null)
            currentPage = musicSource.findAll(PageRequest.of(page, size));
        else
            currentPage = musicSource.findAll(currentPage.nextPageable());
        */
        model.addAttribute("music_list",musicService.getMusicPage(page, size));
        return "music_library";
    }

    @PostMapping("/music")
    @ResponseBody
    public String search(@RequestParam String value){
        return musicService.findMusicByName(value).toString();

    }
}
