package com.kakadurf.cv4.framework.controller.rest;

import com.kakadurf.cv4.domain.entities.Subscribe;
import com.kakadurf.cv4.domain.service.MusicService;
import com.kakadurf.cv4.domain.service.UserManagingService;
import com.kakadurf.cv4.framework.data.dto.MusicDto;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestFeed {
    @Autowired
    UserManagingService userManagingService;
    @Autowired
    MusicService musicService;

    @Operation(summary = "Returns a feed for a given user", tags = {"user", "music"})
    @GetMapping("/api/feed")
    public ResponseEntity<String> getFeed(@AuthenticationPrincipal UserDetailsImpl security){
        List<Subscribe> subscribes = userManagingService.getSubscribes(security.user);
        List<MusicDto> list = musicService.getOnesMusic(subscribes.stream()
                        .map(subscribe -> subscribe.getSubscribable().getId())
                        .collect(Collectors.toList()), Pageable.unpaged());
        return ResponseEntity.ok(list.stream().map(MusicDto::toJSON).collect(Collectors.joining(", ")));
    }
}
