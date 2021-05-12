package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.framework.data.dto.UserDto;
import com.kakadurf.cv4.framework.data.dto.UserSearchForm;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserSearchService {
    List<UserDto> findByData(UserSearchForm searchForm, Pageable pageable);
}
