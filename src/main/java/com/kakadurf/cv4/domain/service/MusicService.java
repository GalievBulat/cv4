package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.framework.transport.MusicDto;

import java.util.List;

public interface MusicService {
    List<MusicDto> getMusicPage(int page, int size);
    List<String> findMusicJSONByName(String value);
}
