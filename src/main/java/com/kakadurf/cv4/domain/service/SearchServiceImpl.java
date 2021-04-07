package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class SearchServiceImpl implements SearchService {
    @Autowired
    UserSource userSource;
    public Optional<List<UserEntity>> searchForUsers(String name, int limit, int page){
        return userSource.findUsersByEmail(name, PageRequest.of(page-1, limit));
    }
}
