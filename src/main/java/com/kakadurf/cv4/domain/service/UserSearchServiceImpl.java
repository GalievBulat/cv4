package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.framework.data.dto.UserDto;
import com.kakadurf.cv4.framework.data.dto.UserSearchForm;
import com.kakadurf.cv4.framework.data.transport.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserSearchServiceImpl implements UserSearchService {
    @Autowired
    UserSource userSource;
    @Override
    public List<UserDto> findByData(UserSearchForm searchForm, Pageable pageable){
        return userSource.findUserByNameOrEmail(
                searchForm.getName()!= null? searchForm.getName().length()>0 ? searchForm.getName() : null: null,
                searchForm.getEmail() != null ? searchForm.getEmail().length()>0 ? searchForm.getEmail() : null : null,
                pageable)
                .stream()
                .map(UserMapper.INSTANCE::userToDto)
                .collect(Collectors.toList());
    }

}
