package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.framework_presentation.transport.MusicDto;

import java.util.List;

public interface MusicService {
    List<MusicDto> getMusicPage(int page, int size);
    List<String> findMusicByName(String value);
}
