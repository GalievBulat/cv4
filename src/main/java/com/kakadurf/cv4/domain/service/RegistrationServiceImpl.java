package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.db_interface.UserManager;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.domain.entities.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private UserManager userManager;
    public void signUp(UserData form){
        userManager.save(UserEntity.builder()
                .name(form.getName())
                .email(form.getEmail())
                .phoneNum(form.getPhone_num())
                .surname(form.getSurname())
                .tc(form.getTc())
                .password(form.getPassword()).build());
    }
}
