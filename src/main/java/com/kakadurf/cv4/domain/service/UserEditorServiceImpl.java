package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEditorServiceImpl implements UserEditorService {
    @Autowired
    UserSource source;

    public void replaceUser(UserEntity newUser){
        source.save(newUser);
    }
}
