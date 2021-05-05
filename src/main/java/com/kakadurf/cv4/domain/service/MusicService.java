package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.entities.MusicInfo;
import com.kakadurf.cv4.framework.data.dto.MusicDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MusicService {
    List<MusicDto> getMusicPage(int page, int size);
    List<String> findMusicJSONByName(String value);
    List<MusicDto> findMusicPage(MusicInfo musicInfo, int page, int size);

    List<MusicDto> getOnesMusic(List<Long> ids, Pageable pageable);
}
