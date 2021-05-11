package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework.data.dto.UserDto;

import java.util.Optional;

public interface UserManagingService {
    void replaceUser(UserEntity newUser);
    public void subscribeToUser(long subscriberId, long subscribableId);
    public void subscribeToUser(UserEntity subscriber, UserEntity subscribable);

    Optional<UserDto> findUser(Long id);
}
