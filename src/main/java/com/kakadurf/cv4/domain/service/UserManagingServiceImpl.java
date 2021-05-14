package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.datasource.SubscribeSource;
import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.Subscribe;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework.data.dto.UserDto;
import com.kakadurf.cv4.framework.data.transport.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserManagingServiceImpl implements UserManagingService {
    @Autowired
    UserSource source;
    @Autowired
    SubscribeSource subscribeSource;
    public Optional<UserDto> findUser(Long id){
       return source.findById(id).map(UserMapper.INSTANCE::userToDto);
    }
    public void replaceUser(UserEntity newUser){
        source.save(newUser);
    }
    public void subscribeToUser(long subscriberId, long subscribableId){
        if (subscribableId != subscriberId) {
            UserEntity subscriber = source.findById(subscriberId).orElseThrow(IllegalArgumentException::new);
            UserEntity subscribable = source.findById(subscribableId).orElseThrow(IllegalArgumentException::new);
            subscribeSource.save(Subscribe.builder()
                    .subscriber(subscriber)
                    .subscribable(subscribable)
                    .build());
        } else throw new IllegalArgumentException("Профили совпадают");
    }
    public void subscribeToUser(UserEntity subscriber, UserEntity subscribable){
        subscribeSource.save(Subscribe.builder()
                .subscriber(subscriber)
                .subscribable(subscribable)
                .build());
    }
}
