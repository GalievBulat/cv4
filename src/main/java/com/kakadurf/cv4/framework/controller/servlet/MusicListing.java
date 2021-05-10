package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.entities.MusicInfo;
import com.kakadurf.cv4.domain.service.MusicService;
import com.kakadurf.cv4.framework.data.dto.MusicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@PreAuthorize("isAu")
@Controller
public class MusicListing {


    @Autowired
    MusicService musicService;

    @GetMapping("/music")
    public String getSearchPage(Model model,
                                MusicInfo musicInfo,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10" ) int size){
        if (musicInfo != null){
            List<MusicDto> musicEntityList = musicService.findMusicPage(musicInfo,page-1,size);
            model.addAttribute("music_list",musicEntityList);
        } else
            model.addAttribute("music_list",musicService.findMusicPage(new MusicInfo(),page-1, size));
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
