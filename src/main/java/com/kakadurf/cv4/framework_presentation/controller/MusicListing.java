package com.kakadurf.cv4.framework_presentation.controller;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework_presentation.db_interface.MusicRepository;
import com.kakadurf.cv4.framework_presentation.transport.MusicDto;
import com.kakadurf.cv4.framework_presentation.transport.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    MusicRepository musicRepository;

    private final int size = 10;

    @GetMapping("/music")
    public String getSearchPage(Model model){
        //MusicMapper mapper =
        model.addAttribute("music_list",
                musicRepository.findAll(PageRequest.of(0, size))
                        .stream().map(MusicMapper.INSTANCE::musicToDto)
                        .collect(Collectors.toList()));
        return "music_library";
    }

    @PostMapping("/music")
    @ResponseBody
    public String search(@RequestBody String name){
        return musicRepository.findByName(name, PageRequest.of(0, size))
                .orElseThrow(RuntimeException::new).stream()
                .map(MusicMapper.INSTANCE::musicToDto)
                .map(MusicDto::toJSON)
                .collect(Collectors.toList()).toString();
    }
}
