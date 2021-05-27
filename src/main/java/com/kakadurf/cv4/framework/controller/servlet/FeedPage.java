package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.entities.Subscribe;
import com.kakadurf.cv4.domain.service.interfaces.MusicService;
import com.kakadurf.cv4.domain.service.interfaces.UserManagingService;
import com.kakadurf.cv4.domain.transport.dto.MusicDto;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("isAuthenticated()")
public class FeedPage {
    @Autowired
    MusicService musicService;
    @Autowired
    UserManagingService userManagingService;
    @GetMapping("/feed")
    public String getFeedPage(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10" ) int size,
            @AuthenticationPrincipal UserDetailsImpl security,
                          Model model){
        List<Subscribe> subscribes = userManagingService.getSubscribes(security.user);
        List<MusicDto> list = musicService.getOnesMusic(subscribes.stream()
                .map(subscribe -> subscribe.getSubscribable().getId())
                .collect(Collectors.toList()),
                PageRequest.of(page-1, size, Sort.by(Sort.Direction.ASC, "musicFile_uploadDate")));
        model.addAttribute("music_list",list);
        return "music_library";
    }
}
