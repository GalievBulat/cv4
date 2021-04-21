package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.datasource.MusicSource;
import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.framework_presentation.transport.MusicDto;
import com.kakadurf.cv4.framework_presentation.transport.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MusicServiceImpl implements MusicService {

    @Autowired
    MusicSource musicSource;

    public List<MusicDto> getMusicPage(int page, int size){
        return musicSource.findAll(PageRequest.of(page, size))
                .stream().map(MusicMapper.INSTANCE::musicToDto)
                .collect(Collectors.toList());
    }
    public  List<String> findMusicByName(String value){
        return musicSource.findByName(value)
                .stream()
                .map(MusicMapper.INSTANCE::musicToDto)
                .map(MusicDto::toJSON)
                .collect(Collectors.toList());
    }

}
