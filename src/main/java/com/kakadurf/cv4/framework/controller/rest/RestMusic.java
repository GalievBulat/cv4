package com.kakadurf.cv4.framework.controller.rest;

import com.kakadurf.cv4.domain.datasource.MusicSource;
import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.framework.data.dto.MusicDto;
import com.kakadurf.cv4.framework.data.transport.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestMusic {
    @Autowired
    MusicSource musicSource;
    @GetMapping("/api/music/{fileName}")
    public ResponseEntity<String> getMusic(@RequestParam("fileName") String fileName){
        List<MusicEntity> music=  musicSource.findByName(fileName);
        return ResponseEntity.ok(music.stream()
                .map(MusicMapper.INSTANCE::musicToDto)
                .map(MusicDto::toJSON)
                .collect(Collectors.toList()).toString());
    }
}
