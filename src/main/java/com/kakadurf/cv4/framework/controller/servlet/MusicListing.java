package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.domain.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@PreAuthorize("isAu")
@Controller
public class MusicListing {


    @Autowired
    MusicService musicService;

    @GetMapping("/music")
    public String getSearchPage(Model model,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10" ) int size){
        //MUSICDTO
        if (name != null && !name.isEmpty()){
            List<String> musicEntityList = musicService.findMusicJSONByName(name);
            model.addAttribute("music_list",musicEntityList);
        } else
            model.addAttribute("music_list",musicService.getMusicPage(page-1, size));
        return "music_library";
    }
/*
REST!
    @GetMapping("/music/find_by_")
    @ResponseBody
    public String search(@RequestParam String value){
        return musicService.findMusicByName(value).toString();
    }*/
}
