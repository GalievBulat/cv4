package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.datasource.SubscribeSource;
import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.Subscribe;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework.data.dto.MusicDto;
import com.kakadurf.cv4.framework.data.dto.UserDto;
import com.kakadurf.cv4.framework.data.dto.UserSearchForm;
import com.kakadurf.cv4.framework.data.transport.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserManagingServiceImpl implements UserManagingService, UserSearchService {
    @Autowired
    UserSource source;
    @Autowired
    SubscribeSource subscribeSource;
    public Optional<UserDto> findUser(Long id){
       return source.findById(id).map(UserMapper.INSTANCE::userToDto);
    }

    @Override
    public List<UserDto> findByData(UserSearchForm searchForm, Pageable pageable){
        return source.findUserByNameOrEmail(
                searchForm.getName()!= null? searchForm.getName().length()>0 ? searchForm.getName() : null: null,
                searchForm.getEmail() != null ? searchForm.getEmail().length()>0 ? searchForm.getEmail() : null : null,
                pageable)
                .stream()
                .map(UserMapper.INSTANCE::userToDto)
                .collect(Collectors.toList());
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
    public  List<Subscribe> getSubscribes(UserEntity user){
        return
                subscribeSource.findBySubscriber_Id(user.getId());

    }
}
