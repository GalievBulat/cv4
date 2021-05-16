package com.kakadurf.cv4.framework.controller.rest;

import com.kakadurf.cv4.domain.datasource.MusicSource;
import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.framework.data.dto.MusicDto;
import com.kakadurf.cv4.framework.data.transport.MusicMapper;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestMusic {
    @Autowired
    MusicSource musicSource;
    @Operation(summary = "Returns a music info", tags = "music")
    @GetMapping("/api/music/{fileName}")
    public ResponseEntity<String> getMusic(@RequestParam("fileName") String fileName){
        List<MusicEntity> music=  musicSource.findByName(fileName);
        return ResponseEntity.ok(music.stream()
                .map(MusicMapper.INSTANCE::musicToDto)
                .map(MusicDto::toJSON)
                .collect(Collectors.toList()).toString());
    }
    @Operation(summary = "Returns a user info", tags = "user")
    @GetMapping("/api/auth")
    public ResponseEntity<String> getMusic(
                                           @AuthenticationPrincipal UserDetailsImpl security){
        //Object userEntity = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(security.user.toString());
    }
}
