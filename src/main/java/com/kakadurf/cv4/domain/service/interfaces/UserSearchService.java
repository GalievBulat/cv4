package com.kakadurf.cv4.domain.service.interfaces;

import com.kakadurf.cv4.domain.transport.dto.UserDto;
import com.kakadurf.cv4.domain.transport.dto.UserSearchForm;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserSearchService {
    List<UserDto> findByData(UserSearchForm searchForm, Pageable pageable);
}
