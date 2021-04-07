package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface SearchService {
    public Optional<List<UserEntity>> searchForUsers(String name, int limit, int page);
}
