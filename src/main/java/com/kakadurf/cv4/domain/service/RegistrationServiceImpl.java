package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.UserData;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private UserSource userSource;
    @Autowired
    private PasswordEncoder encoder;

    public void signUp(UserData form){
        userSource.save(UserEntity.builder()
                .name(form.getName())
                .email(form.getEmail())
                .phoneNum(form.getPhone_num())
                .surname(form.getSurname())
                .hashedPassword(encoder.encode(form.getPassword()))
                .state(UserEntity.State.NONCONFIRMED)
                .build());
    }
}
